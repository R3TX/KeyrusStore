package com.keyrus.keyrusStore.order;


import com.keyrus.keyrusStore.orderProduct.OrderProductDTO;
import com.keyrus.keyrusStore.orderProduct.OrderProductModel;
import com.keyrus.keyrusStore.orderProduct.OrderProductService;
import com.keyrus.keyrusStore.utility.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de la logica del negocio de las ordenes
 */
@Service
public class OrderService {

    @Autowired
    private IOrderRepository iOrderRepository;
    @Autowired
    private OrderProductService orderProductService;
    @Autowired
    private Mapper mapper;

    /**
     * recibe un DTO, lo mapea  a una entidad y lo guarda en la base de datos
     * @param orderDTO
     * @return
     */
    public OrderDTO createOrder(OrderDTO orderDTO){

        OrderModel orderModel = (OrderModel) mapper.mapToEntity(orderDTO);
        orderModel =iOrderRepository.save(orderModel);
        createOrderProduct(orderModel);
        orderDTO.setOrderId(orderModel.getId());

        return orderDTO;
    }

    /**
     * Recibe una orden a la cual se le han borrado,
     * agregado o modificado los productos y el cliente y lo guarda en la base de datos
     * @param orderDTO
     * @return
     */
    public OrderDTO updateOrderDynamic(OrderDTO orderDTO){

        OrderModel orderModel= (OrderModel) mapper.mapToEntity(orderDTO);
        iOrderRepository.save(orderModel);

        List<OrderProductModel> productModelsOld= new ArrayList<>();
        orderProductService.readByOrderId(Long.valueOf(orderModel.getId())).forEach(productModelsOld::add );
        List<OrderProductDTO> dtos =orderModel.getProducts();

        //se crea los array que guradaran las coincidencias entre orderproduct
        List<OrderProductModel> aux1 = new ArrayList<>();
        List<OrderProductDTO> aux2 = new ArrayList<>();

        //se buscan y actualizan los que aun existen
        for( OrderProductModel orderProductModel : productModelsOld){

            for(OrderProductDTO productModel : dtos){

                if(orderProductModel.getId()==productModel.getId()){
                    orderProductModel.setQuantity(productModel.getQuantity());
                    orderProductModel.setId(productModel.getId());
                    orderProductService.updateOrderProduct(orderProductModel);
                    aux1.add(orderProductModel);
                    aux2.add(productModel);
                }
            }
        }

        //se borran los viejos  que se Actualizaron
        productModelsOld.removeAll(aux1);

        //se borra los nuevos que actualizaron los viejos
        dtos.removeAll(aux2);

        //se borran los viejos que no se repitieron
        productModelsOld.iterator()
                .forEachRemaining(orderProductModel -> orderProductService.deleteOrderProduct(orderProductModel));

        //se agregan los nuevos
        createOrderProduct(orderModel);


        return  orderDTO;

    }

    /**
     * Recibe una orden a la cual se le ha modificado
     * la cantidad de unidades de uno o varios productos
     * @param orderDTO
     * @return
     */
    public OrderDTO updateQuantity(OrderDTO orderDTO){

        OrderModel orderModel =(OrderModel) mapper.mapToEntity(orderDTO);
        List<OrderProductDTO> orderModelsToUpdate = orderModel.getProducts();
        iOrderRepository.save(orderModel);
        Iterable<OrderProductModel> orderProductModels = orderProductService.readByOrderId(orderModel.getId());
        int i = 0;

        for(OrderProductModel orderProductModel : orderProductModels){ //asumo que estan en el mismo orden

            orderProductModel.setQuantity(orderModelsToUpdate.get(i).getQuantity());
            orderProductService.updateOrderProduct(orderProductModel);
            i++;
        }

        return orderDTO;
    }

    /**
     * Busca en la base de datos una orden dada su id
     * @param orderId
     * @return
     */
    public OrderDTO readOrder(Long orderId){

        OrderDTO orderDTO = (OrderDTO) mapper.mapToDTO(iOrderRepository.findOne(orderId));
        List products = mapper.mapToDTOList(orderProductService.readByOrderId(orderId));

        orderDTO.setProductList(products);


        return orderDTO;
        /*
        OrderModel orderModel =iOrderRepository.findOne(orderId);
        Iterable<OrderProductModel> products = orderProductService.readByOrderId(orderId);
        List<OrderProductDTO> orderProductDTOS=new ArrayList<>();

        for (OrderProductModel orderProductModel: products){
            orderProductDTOS.add(conversor.convertEntityToDTO(orderProductModel));
        }

        return  conversor.convertEntityToDTO(orderModel,orderProductDTOS);
        */
    }

    /**
     * Borra un order dado su id
     * @param id
     * @return
     */
    public String deleteOrder(Long id){
        iOrderRepository.delete(id);
        return "Deleted";
    }

    /**
     * devuelve todas las ordenes que hay en la base de datos
     * @return
     */
    public  Iterable<OrderDTO> readAll(){

        Iterable<OrderModel> orderModels= iOrderRepository.findAll();


        return (Iterable<OrderDTO>) mapper.mapToDTOList(orderModels);
    }

    /**
     * retorna todas las ordenes que un usuario tiene en la BD
     * @param id
     * @return
     */
    public Iterable<OrderDTO> readByUserId(Long id){

        Iterable<OrderModel> orderModels =iOrderRepository.findByCustomerModelId(id);

        return (Iterable<OrderDTO>) mapper.mapToDTOList(orderModels);
    }



    public void createOrderProduct(OrderModel orderModel){

        List<OrderProductModel> orderProductModels = mapper.mapTOEntityList(orderModel.getProducts());
        for(OrderProductModel orderProductModel:orderProductModels){
            orderProductModel.setOrder(orderModel);
        }
        orderProductService.createOrderProductAll(orderProductModels);

    }

}
