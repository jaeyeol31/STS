package delivery.service;

import delivery.DTO.DeliveryDTO;

import java.util.ArrayList;

public interface DeliveryService {
    public ArrayList<DeliveryDTO> deliverySelectAll();
    public DeliveryDTO deliverySelect(int order_id);
    public DeliveryDTO deliveryInsert(DeliveryDTO deliveryDTO);
    public DeliveryDTO deliveryUpdate(DeliveryDTO deliveryDTO);
    public DeliveryDTO deliveryDelete(int order_id);

}
