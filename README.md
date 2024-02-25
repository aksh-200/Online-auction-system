# E-Antique:Online-Auction-System

Abstract:
The Online Auction System has three main parts: Seller, Buyer, and Admin modules. Sellers can sign up, add products for auction, set prices, end auctions, and answer questions. Buyers can register, bid on products, see descriptions, check seller ratings, rate products and sellers, and ask questions. The Admin module handles system management, including KYC checks, authorization based on government IDs, product verification, and removing fraudulent sellers and buyers. This system ensures a secure and transparent online auction experience for everyone involved

Introduction:
Welcome to the Online Auction System, a user-friendly platform designed with three essential modules: Seller, Buyer, and Admin. In this virtual marketplace, sellers can easily register, create accounts, and showcase their products for auction, setting base prices and having control over the auction process.
For sellers, the system offers features like ending auctions, monitoring current bid prices, and engaging with potential buyers by answering their questions. On the buyer's side, the platform enables hassle-free registration, bidding on products, accessing detailed product descriptions, and checking seller ratings for authenticity.
Ensuring the integrity of the system is the Admin module. Admins play a crucial role in authorizing participants through KYC checks, verifying government identity proofs, and ensuring the legitimacy of each product before it goes up for auction. The admin also has the authority to remove any fraudulent sellers and buyers, maintaining a secure and trustworthy online auction environment for all users. Join us in exploring a world of seamless transactions, genuine interactions, and secure online auctions
Document Purpose:


Project Background:

There is no computerized system for auctioning valuable products. Currently, the seller goes to nearest auctioning house or sell the product directly without auctioning online or offline, in both online and offline selling of product there are chances of bargaining for price by buyer. There are chances of frauds in case of selling valuable products online for both buyer and seller. Seller can only fix a price for selling and in some cases, buyers tends to bargain for the product. There is no way for buyer to check where the product is genuine or stolen. No facility is present for both buyers and sellers to detect chances of fraud during buying or selling.

Aim & Objectives:

The main objective of this project is building a website which will help buyers and sellers 	to participate in auction. Here if suppose some seller or buyer want to use this facility and 	learn how is it possible and how they can use Online Auction System to buy or sell the 	products, they must have knowledge of computer then they can directly register in the site 	and sell or buy the products online.

Problem definition:

Creating an online auction system involves building a website or app where people can sell and buy items through bidding. Users should be able to register, list their products for auction, and others can place bids. The system needs to handle secure payments, provide real-time updates on ongoing auctions, and have a way to resolve disputes. It's important to make it user-friendly, secure, and able to handle a large number of users and items.
SCOPE:
 This system is designed as an online web-based application which shall be accessed by any device, either a computer, tablet, iPad, iPhone, mobile phone or PDAs.
The scope of this application to build a user friendly auctioning website, where user will be able to auctioned any product which is available nearby or anywhere in the world. By using Online Auction management system it will be easy for auctioneer to make an auction and time saving also. By making auction through this application will help to reach maximum of buyers bidding . There will be a feature where bidder and seller can message each other
Scope for online auction system:
The scope for an online auction system encompasses the various features and functionalities that the system should include. Here's a concise scope:

User Management:

User registration and authentication.
User profiles with bidding history.

Product Management:
Item listing with details and images.
Categories for organizing products.

Bidding Mechanism:

Bidding interface for users.

Automatic bid increments and proxy bidding.

Auction Management:

Creation, editing, and ending of auctions.

Setting auction parameters (duration, starting bid, etc.).

Real-Time Updates:

Instant notifications for bids and auction status changes.

Payment Integration:

Secure payment gateway integration.

Multiple payment options.

Search and Filters:

Search functionality with filters (category, price range, etc.).

Security Features:

Encryption for data security.

Fraud detection and prevention measures.

User Dashboards:

Personalized dashboards for tracking auctions and bids.

Feedback and Ratings:

Feedback system for buyers and sellers.

Rating system to build trust.

Mobile Responsiveness:

Responsive design for mobile and tablet users.

Scalability:

Design to accommodate a growing user base and items.

Reporting and Analytics:

Reporting tools for auction performance.

Analytics for sellers to optimize listings.

Legal and Compliance:

Compliance with relevant laws and regulations.

Clearly defined terms of service.

Customer Support:

Customer support features for issue resolution.

Frequently Asked Questions (FAQ) section.

By focusing on these aspects, the online auction system can provide a user-friendly, secure, and efficient platform for buying and selling through auctions.

Constraints:
The choice of the database to use should be considered carefully, since there will be a lot of data traffic and the large amounts of data will also judge the database. A good database will yield speed querying of data.

The browser used should support HTML5 to satisfy user experience.

The device should be enabled with internet.

Outcomes:
Price Discovery:

Online auctions facilitate price discovery by allowing buyers to bid based on their perceived value of an item. The final winning bid reflects the market's assessment of the item's worth.
Market Reach:

Online auctions provide a broader market reach, allowing sellers to connect with a global audience. This can lead to increased competition and potentially higher prices for items.
Efficiency:

Compared to traditional auctions, online auctions can be more efficient. They reduce the time and geographical constraints associated with physical auctions.
Data and Analytics:

Online auctions generate a wealth of data that can be analyzed to understand buyer behavior, market trends, and the performance of different items. This information can be valuable for sellers and the auction platform.
Dynamic Pricing:

Prices in online auctions can be dynamic, adjusting in real-time based on bidding activity. This allows for a more flexible pricing model compared to fixed-price sales.
Diversity of Items:

Online auctions can accommodate a wide range of items, from rare collectibles to everyday goods. This diversity attracts a broad audience with varied interests.
Competitive Bidding:

The competitive nature of online auctions can result in higher prices for sellers. Bidders compete with each other, driving the final bid closer to the true market value of the item.




Purpose System:
The proposed computerized online auction system  has made auction process simple. The only
5 pre-condition is that the user must register and authenticate before he/she can take part in the bidding process. The system uses HTTP forms authentication which creates a session cookie for any signed in user. Through out the span of the session the cookie remains valid until the user logs out.

An auction house needs to have products to auction, so in the proposed system this is done using product registration module. The module is open to user who is registered sellers and they need to authenticate before they register antique product. 

Another important module in the proposed project is the "Bidding module ". Here one can see the details of any particular product and also the bidding history. The user can bid on that item by entering any amount greater than or equal to the incremental bid amount. Here also system checks to see whether the user has his credential verified otherwise he/she will be directed to the login/registration page.

The last but the least module is the "Web Administration" module. The module is only open to the web administrator due to security reasons. In this module the administrator have access to verify product .

There is another module which runs more or less like background process. The function of the module is to close bid of those products whose closing date is less than the current date. The process is automatic and hidden from the web users.

Modules



Online Auction System consists of three modules described as bel

Seller Module
Bidder Module
Admin Module


3.1 Seller Module
Seller can register and create his own account.

Online Auction System provides the function which allows Sellers to add their products for auction.

Seller can set base price for the product added.

The Seller can end the auction.

The Seller can see the current bid price on the product added.
seller can give answers of buyer questions






 Bidder Module
Bidder can register and create his own account.

Online Auction System provides the function which allow buyers to bid on product and see the description of product.

  bidder can see sellers rating for authenticity 

Bidder can rate the product and seller

buyer can ask questions

3.3 Admin Module:

Online Auction System should provide all functions to admin how to handle the System.

Admin can check KYC and authorize bidder/buyers and sellers based on Government Identity proof.

Admin can verify every product before it goes for auctioning.

Admin can remove fraud Sellers and Buyers.




4.	Non-Functional Requirement:



•	The website should use professional design, look and feel and color scheme.

•	Users will have no limitations for accessing the application through Internet. The portal being an internet application, it is difficult specify exact number of visitor or users. Hence we will target the system to support multiple users .
 
•	Being a public website, the site must follow general usability guidelines for menus, navigation, colors, links and other actions provided on the screens.

•	The system should be designed in such a manner that user will be able to complete tasks in minimum number of steps.
Hardware interface
It is web based product. The hardware on which it resides will be any computer can have
internet.
The hardware requirement includes a system with following configurations:
• Processor: Intel Pentium or above
• RAM: 1 GB
• Input device: Standard Keyboard and Mouse
• Output device : VGA and High Resolution Monitor
Software interference
This project is web based model so only browser with internet connection is required from
user standpoint. This product will utilize various software components for its web based
functionality. Web server require to host website from developers' standpoint.
• Frontend: HTMM, CSS, JS
• Backend: Django
• Database: MySQQ
