select* from Buyer
-- Table for Buyer
CREATE TABLE Buyer (
    BuyerID INT IDENTITY PRIMARY KEY, -- Assuming a unique ID for each buyer
    FNAME NVARCHAR(50) NOT NULL,
    LNAME NVARCHAR(50) NOT NULL,
    Username NVARCHAR(50) UNIQUE NOT NULL,
    Phone NVARCHAR(15),
    BuyerLocation NVARCHAR(100),
    Password NVARCHAR(255) NOT NULL
);

-- Table for Seller
CREATE TABLE Seller (
    SellerID INT PRIMARY KEY, -- Same as BuyerID
    CNIC NVARCHAR(20) UNIQUE NOT NULL, -- Unique CNIC for the seller
    CategoryID INT NOT NULL, -- Category the seller belongs to
    FOREIGN KEY (SellerID) REFERENCES Buyer(BuyerID), -- Links SellerID to BuyerID
    FOREIGN KEY (CategoryID) REFERENCES Category(CategoryID) -- Links CategoryID to the Category table
);

-- Table for Category
CREATE TABLE Category (
    CategoryID INT IDENTITY PRIMARY KEY,
    CategoryType NVARCHAR(50) NOT NULL
);

-- Gig Table
CREATE TABLE Gig (
    GigID INT IDENTITY PRIMARY KEY, -- Unique identifier for each gig
    GigDescription NVARCHAR(MAX), -- Description of the gig
    SellerID INT NOT NULL, -- ID of the seller who owns the gig
    FOREIGN KEY (SellerID) REFERENCES Seller(SellerID) -- Foreign key relationship with Seller table
);
Select* from Gig where sellerid = 1
drop table Chat
Select sender from chat where chatid = 1 and currentUser = 'Buyer'
select* from chat where chatid = 1;
-- Chat Table
select * from chat where sender = 20
Select sender from chat where chatid = ? and currentUser = 'Buyer'


SELECT CASE WHEN sender = 20 THEN reciver WHEN reciver = 20 THEN sender END AS OppositeUserID FROM Chat WHERE ChatID = 11;
CREATE TABLE Chat (
    ChatID INT IDENTITY PRIMARY KEY, -- Unique identifier for each chat session
    Sender INT NOT NULL,
	Reciver INT NOT NULL,
    CurrentUser NVARCHAR(10) NOT NULL, -- Identifies if the current user is 'Seller' or 'Buyer'
    FOREIGN KEY (Sender) REFERENCES Buyer(BuyerID),
	FOREIGN KEY (Reciver) REFERENCES Buyer(BuyerID)
);
-- ChatMessages Table
CREATE TABLE ChatMessages (
    ChatID INT NOT NULL, -- Links to the Chat table
	Sender INT NOT NULL,
    MessageID INT IDENTITY PRIMARY KEY, -- Unique identifier for each message
    MessageDescription NVARCHAR(MAX) NOT NULL, -- The message content
    Timestamp DATETIME DEFAULT GETDATE(), -- Timestamp of when the message was sent
    FOREIGN KEY (ChatID) REFERENCES Chat(ChatID),
	FOREIGN KEY (Sender) REFERENCES Buyer(BuyerID)
);

-- Table for Order
CREATE TABLE Orders (
    OrderID INT IDENTITY PRIMARY KEY,
    GigID INT NOT NULL,
    SellerID INT NOT NULL,
    BuyerID INT NOT NULL,
    SellerReview INT,
    OrderStatus NVARCHAR(50),
	OrderDate DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (GigID) REFERENCES Gig(GigID),
    FOREIGN KEY (SellerID) REFERENCES Seller(SellerID),
    FOREIGN KEY (BuyerID) REFERENCES Buyer(BuyerID)
);


select * from Orders
