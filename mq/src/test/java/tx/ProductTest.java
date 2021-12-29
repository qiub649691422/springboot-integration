/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package tx;

import com.liqiubo.mq.rabbit.tx_demo.tx_core.entity.Order;
import com.liqiubo.mq.rabbit.tx_demo.tx_product.ProductApplication;
import com.liqiubo.mq.rabbit.tx_demo.tx_product.service.IProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= ProductApplication.class)
public class ProductTest {

	@Autowired
	private IProductService productService;
	
	@Test
	public void updateProduct() throws Exception{
		Order order = new Order();
		order.setProductId(1006);
		order.setCustomer("Five");
		order.setNumber(1);
		productService.updateProduct(order);
	}
}
