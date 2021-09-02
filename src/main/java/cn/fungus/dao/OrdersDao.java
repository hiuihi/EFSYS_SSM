package cn.fungus.dao;

import cn.fungus.domain.Order;
import cn.fungus.domain.OrderGoods;
import cn.fungus.domain.Reimburse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersDao {

    /**
     * 插入订单信息
     * @param
     */
    void insertOrder(Order order);

    /**
     * 分页查询订单信息
     * @param
     */
    List<Order> selectOrderByUid(@Param("userId") Long userId,@Param("orderStatus")String orderStatus, @Param("term")String term,@Param("start") Integer start, @Param("rows")Integer rows);
    /**
     * 分页查询所有订单信息
     * @param
     */
    List<Order> selectAllOrder(@Param("orderStatus")String orderStatus,@Param("orderSn")String orderSn,@Param("userId")String userId,@Param("start") Integer start, @Param("rows")Integer rows);
    /**
     * 查询订单条数
     * @param
     */
    Long selectCount(@Param("orderStatus")String orderStatus,@Param("orderSn")String orderSn,@Param("userId")String userId);

    /**
     * 根据订单号查询订单信息
     * @param
     */
    Order selectOrderByUidSn(String orderSn);

    /**
     * 根据uid查询订单条数
     * @param
     */
    Long selectCountByUid(@Param("userId")Long userId,@Param("orderStatus")String orderStatus);

    /**
     * 修改订单状态
     * @param order
     */
    void updOrderStatusByUidSn(Order order);
    /**
     * 删除订单
     * @param orderSn
     */
    void delOrderByUidSn(@Param("orderSn")String orderSn);
    /**
     * 修改订单物流信息
     * @param order
     */
    void updOrderDelivery(Order order);

    /**
     * 修改订单状态为待发货等
     * @param orderStatus,orderSn
     */
    void updOrderStatusByOrderSn(@Param("orderStatus")Integer orderStatus,@Param("orderSn")String orderSn);


    /**
     * 插入订单订单商品信息
     * @param
     */
    void insertOrderGoods(OrderGoods orderGoods);

    /**
     * 查询订单商品信息
     * @param
     */
    List<OrderGoods> selectOrderGoodsByOrderSn(String orderSn);
    /**
     * 查询所有订单商品信息
     * @param
     */
    List<OrderGoods> selectAllOrderGoods();

    /**
     * 查询订单商品信息根据订单号和输入框的内容
     * @param
     */
    List<OrderGoods> getOrderGoodsByOrderSnAndTerm(@Param("orderSn")String orderSn,@Param("term")String term);
    /**
     * 插入退款
     * @param reimburse
     */
    void insertReimburse(Reimburse reimburse);

    /**
     * 查询退款信息
     * @param orderSn
     * return Reimburse
     */
    Reimburse selectReimburseByOrderSn(String orderSn);

    /**
     * 修改退款卖家意见
     * @param reimburse
     */
    void updRSellerOpinionByOrderSn(Reimburse reimburse);
    /**
     * 修改退款卖家说明
     * @param reimburse
     */
    void updRSellerCaptionByOrderSn(Reimburse reimburse);
    /**
     * 修改退款物流单号
     * @param reimburse
     */
    void updRDeliveryByOrderSn(Reimburse reimburse);
    /**
     * 修改退款状态
     * @param reimburse
     */
    void updRDeliveryStatusByOrderSn(Reimburse reimburse);
    /**
     * 修改地址
     * @param reimburse
     */
    void updRAddressByOrderSn(Reimburse reimburse);
    /**
     * 取消退款请求
     * @param orderSn
     */
    void delRByOrderSn(String orderSn);
}