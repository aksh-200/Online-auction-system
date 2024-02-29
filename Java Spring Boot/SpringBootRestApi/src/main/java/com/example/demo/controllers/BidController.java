package com.example.demo.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.BidEntry;
import com.example.demo.entities.Bidding;
import com.example.demo.entities.BiddingTransaction;
import com.example.demo.entities.Mybids;
import com.example.demo.entities.Product;
import com.example.demo.entities.User;
import com.example.demo.services.BiddingService;
import com.example.demo.services.ProductService;

@CrossOrigin(origins = {"http://localhost:3000" ,"https://react-auction-app-8080-tb6e.vercel.app"})
@RestController
public class BidController {

	@Autowired
	BiddingService bserv;
	
	@Autowired
	ProductService pserv;
	
	
	
	@PostMapping("/bid/{P_Id}")
	public BiddingTransaction bid(@PathParam("P_Id") Integer P_Id,@RequestBody BidEntry bidEntry)
	{
		System.out.println(bidEntry.getP_Id()+ " "+ bidEntry.getBidder_id() + " "+ bidEntry.getBid_price());
		return bserv.bid(Integer.parseInt(bidEntry.getP_Id()),bidEntry.getBidder_id(),bidEntry.getBid_price());
	}
	
	@GetMapping("/getadminhome")
	public List<Bidding> getAdminHome()
	{
		List<Product> products = pserv.getCompletedAuctionProducts();
		List<BiddingTransaction> bts =new ArrayList<>();
		List<Bidding> bids= new ArrayList<>();
		
		for(Product p:products)
		{
			if(bserv.findProductInBiddingTable(p.getP_Id())==null)
			{
				BiddingTransaction bt= bserv.findMaxBid(p.getP_Id());
				Bidding b;
				if(bt!=null)
				{
//					Product p_Id, float base_price, User bidder_id, Date start_date, Date end_date,
//					float final_bid_price, String bidding_status
					b=new Bidding(p,p.getBase_price(),bt.getBidder_id(),p.getStart_date(),p.getEnd_date(),bt.getBid_price(),new String("Payment not done yet"));
				}
				else
				{
					b=new Bidding(p,p.getBase_price(),p.getStart_date(),p.getEnd_date(),new String("No bids Placed"));
				}
				bserv.save(b);
			}
		}
		
		bids = bserv.findAllFinalBids();
		
		
		return bids;
		
	}
	
	@GetMapping("/getbidderhome/{bidder_id}")
	public List<Bidding> getBidderHome(@PathVariable("bidder_id") int bidder_id)
	{
		List<Product> products = pserv.getCompletedAuctionProducts();
		List<BiddingTransaction> bts =new ArrayList<>();
		List<Bidding> bids= new ArrayList<>();
		
		for(Product p:products)
		{
			if(bserv.findProductInBiddingTable(p.getP_Id())==null)
			{
				BiddingTransaction bt= bserv.findMaxBid(p.getP_Id());
				Bidding b;
				if(bt!=null)
				{
//					Product p_Id, float base_price, User bidder_id, Date start_date, Date end_date,
//					float final_bid_price, String bidding_status
					b=new Bidding(p,p.getBase_price(),bt.getBidder_id(),p.getStart_date(),p.getEnd_date(),bt.getBid_price(),new String("Payment not done yet"));
				}
				else
				{
					b=new Bidding(p,p.getBase_price(),p.getStart_date(),p.getEnd_date(),new String("No bids Placed"));
				}
				bserv.save(b);
			}
		}
		
		bids = bserv.findAllBidsWon(bidder_id);
		
		
		return bids;
		
	}
	
	@GetMapping("/getsellerhome/{seller_id}")
	public List<Bidding> getSellerHome(@PathVariable("seller_id") int seller_id)
	{
		List<Product> products = pserv.getCompletedAuctionProductsSeller(seller_id);
		List<BiddingTransaction> bts =new ArrayList<>();
		List<Bidding> bids= new ArrayList<>();
		System.out.println(products.size());
		for(Product p:products)
		{
			System.out.println(p.getProduct_name());
			//System.out.println(p.getSeller_id().getFname());
			if(bserv.findProductInBiddingTable(p.getP_Id())==null)
			{
				BiddingTransaction bt= bserv.findMaxBid(p.getP_Id());
				Bidding b;
//				System.out.println(p.getProduct_name());
				if(bt!=null)
				{
//					Product p_Id, float base_price, User bidder_id, Date start_date, Date end_date,
//					float final_bid_price, String bidding_status
					b=new Bidding(p,p.getBase_price(),bt.getBidder_id(),p.getStart_date(),p.getEnd_date(),bt.getBid_price(),new String("Payment not done yet"));
				}
				else
				{
					b=new Bidding(p,p.getBase_price(),p.getStart_date(),p.getEnd_date(),new String("No bids Placed"));
				}
				System.out.println(b);
				bserv.save(b);
			}
		}
		
		//bids = bserv.findAllFinalBids();
		bids= bserv.findsellerhome(seller_id);
         System.out.println("bids are ********************/////////////////");		
		System.out.println(bids);
		
		return bids;
	}
	
	
	@GetMapping("/mybids/{bidder_id}")
	public List<Mybids> mybids(@PathVariable("bidder_id") int bidder_id)
	{
		List<BiddingTransaction> bts= bserv.mybids(bidder_id);
		List<Mybids> mybids= new ArrayList<>();
		float highest_bid_price;
		for(BiddingTransaction bt:bts)
		{
			highest_bid_price = bserv.findHighestBidForProductUsingP_Id(bt.getP_Id().getP_Id());
			mybids.add(new Mybids(bt,highest_bid_price));
		}
		
		return mybids;
	}
	
}
