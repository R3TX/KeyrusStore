package com.keyrus.keyrusStore.utility;

public interface MapEntity <Entity, DTO>{

     DTO mapToDTO(Entity entity);
     Entity mapToEntity(DTO dto);
}
