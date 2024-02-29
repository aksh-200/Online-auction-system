package com.example.demo.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Bidding;
import com.example.demo.entities.BiddingTransaction;
import com.example.demo.entities.Feedback;
import com.example.demo.entities.Mybids;
import com.example.demo.entities.ProductPurchased;
import com.example.demo.entities.ProductSold;
import com.example.demo.entities.ProductSoldSeller;
import com.example.demo.services.BiddingService;
import com.example.demo.services.CategoryService;
import com.example.demo.services.FeedbackService;
import com.example.demo.services.ProductService;
import com.example.demo.services.ProductSoldService;
import com.example.demo.services.UserService;

@CrossOrigin(origins = {"http://localhost:3000" ,"https://react-auction-app-8080-tb6e.vercel.app"})
@RestController
public class ProductSoldController {

	@Autowired
	ProductService pserv;
	
	@Autowired
	ProductSoldService psserv;
	
	@Autowired
	CategoryService cserv;
	
	@Autowired
	UserService userv;
	
	@Autowired
	BiddingService bserv;
	
	@Autowired
	FeedbackService fserv;
	
	@GetMapping("/makepayment/{bid_id}")
	public ProductSold makePayment(@PathVariable("bid_id") int bid_id)
	{
		Bidding b= bserv.findBidById(bid_id);
		
        long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis);  
//        Bidding bid_id, Date sold_date, String payment_mode, String payment_transaction_id,
//		String delivery_status
        ProductSold p= new ProductSold(b,date,"Net Banking","AFGH78545224114","On the way");
        
         
        
        if(p!=null)
        {
        	
        	int num=bserv.changePaymentStatus(bid_id);
        }
        return psserv.save(p);
	}
	
	@PostMapping("/submitfeedback")
	public Feedback submitFeedback(@RequestBody Feedback f)
	{
		return fserv.save(f);
	}
	
	@GetMapping("/productspurchased/{bidder_id}")
	public List<ProductPurchased> productspurchased(@PathVariable("bidder_id") int bidder_id)
	{
		
//		List<BiddingTransaction> bts= bserv.mybids(bidder_id);
//		List<Mybids> mybids= new ArrayList<>();
//		float highest_bid_price;
//		for(BiddingTransaction bt:bts)
//		{
//			highest_bid_price = bserv.findHighestBidForProductUsingP_Id(bt.getP_Id().getP_Id());
//			mybids.add(new Mybids(bt,highest_bid_price));
//		}
		
		List<ProductSold> products= psserv.productsPurchased(bidder_id);
		List<ProductPurchased> pps=new ArrayList<>();
		
		for(ProductSold p:products)
		{
			Feedback f = fserv.findByPid(p.getBid_id().getP_Id());
			pps.add(new ProductPurchased(p,f));
		}
		
		//get feedback using pid of above
		//make dummy class of ProductSold and feedback
		//return dummy class
		return pps;
	}
	
	
	@GetMapping("/productssoldseller/{seller_id}")
	public List<ProductSoldSeller> productsold(@PathVariable("seller_id") int seller_id)
	{
		
//		List<BiddingTransaction> bts= bserv.mybids(bidder_id);
//		List<Mybids> mybids= new ArrayList<>();
//		float highest_bid_price;
//		for(BiddingTransaction bt:bts)
//		{
//			highest_bid_price = bserv.findHighestBidForProductUsingP_Id(bt.getP_Id().getP_Id());
//			mybids.add(new Mybids(bt,highest_bid_price));
//		}
		
		List<ProductSold> products= psserv.productsSoldSeller(seller_id);
		List<ProductSoldSeller> pps=new ArrayList<>();
		
		for(ProductSold p:products)
		{
			Feedback f = fserv.findByPid(p.getBid_id().getP_Id());
			pps.add(new ProductSoldSeller(p,f));
		}
		
		//get feedback using pid of above
		//make dummy class of ProductSold and feedback
		//return dummy class
		return pps;
	}
	
	@GetMapping("/productssoldadmin")
	public List<ProductSoldSeller> productsoldadmin()
	{
		
//		List<BiddingTransaction> bts= bserv.mybids(bidder_id);
//		List<Mybids> mybids= new ArrayList<>();
//		float highest_bid_price;
//		for(BiddingTransaction bt:bts)
//		{
//			highest_bid_price = bserv.findHighestBidForProductUsingP_Id(bt.getP_Id().getP_Id());
//			mybids.add(new Mybids(bt,highest_bid_price));
//		}
		
		List<ProductSold> products= psserv.productsSoldAdmin();
		List<ProductSoldSeller> pps=new ArrayList<>();
		
		for(ProductSold p:products)
		{
			Feedback f = fserv.findByPid(p.getBid_id().getP_Id());
			pps.add(new ProductSoldSeller(p,f));
		}
		
		//get feedback using pid of above
		//make dummy class of ProductSold and feedback
		//return dummy class
		return pps;
	}
	
	
	
}
