package org.vaasm.bookshop.dao;

import java.util.List;

import org.vaasm.bookshop.model.CartInfo;
import org.vaasm.bookshop.model.OrderDetailInfo;
import org.vaasm.bookshop.model.OrderInfo;
import org.vaasm.bookshop.model.PaginationResult;
 
public interface OrderDAO {
 
    public void saveOrder(CartInfo cartInfo);
 
    public PaginationResult<OrderInfo> listOrderInfo(int page,
            int maxResult, int maxNavigationPage);
    
    public OrderInfo getOrderInfo(String orderId);
    
    public List<OrderDetailInfo> listOrderDetailInfos(String orderId);
 
}