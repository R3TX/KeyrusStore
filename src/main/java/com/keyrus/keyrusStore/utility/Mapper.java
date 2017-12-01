package com.keyrus.keyrusStore.utility;

import com.keyrus.keyrusStore.order.OrderDTO;
import com.keyrus.keyrusStore.order.OrderModel;
import com.keyrus.keyrusStore.orderProduct.OrderProductDTO;
import com.keyrus.keyrusStore.orderProduct.OrderProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de mappear una entity a un DTO y viceversa
 * @param <Entity>
 * @param <DTO>
 */
@Component
public class Mapper <Entity,DTO> {


    @Autowired
    private MapOrder mapOrder;
    @Autowired
    private MapOrderProduct mapOrderProduct;


    public Entity mapToEntity(DTO object){

        if(object instanceof OrderDTO){

            return (Entity) mapOrder.mapToEntity((OrderDTO)object);

        }else if(object instanceof OrderProductDTO){

            return (Entity) mapOrderProduct.mapToEntity((OrderProductDTO) object);
        }

        return null;
    }

    public  DTO mapToDTO(Entity object){

        if(object instanceof OrderModel){

            return (DTO) mapOrder.mapToDTO((OrderModel) object);

        }else if(object instanceof OrderProductModel){

            return (DTO) mapOrderProduct.mapToDTO((OrderProductModel) object);
        }

        return null;
    }

    public  List<DTO> mapToDTOList(Iterable<Entity> objects) {

        List<DTO> mapedObjects = new ArrayList<>();

        for(Entity object : objects){

            mapedObjects.add( mapToDTO( object));
        }

        return mapedObjects;
    }

    public  List<Entity> mapTOEntityList(Iterable<DTO> objects) {

        List<Entity> mapedObjects = new ArrayList<>();

        for(DTO object : objects){

            mapedObjects.add( mapToEntity( object));
        }

        return mapedObjects;
    }


}
