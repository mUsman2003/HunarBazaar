
-- Chat 1: Buyer (1) -> Seller (20) interaction
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (1, 1, 'Hello, I am interested in your product.');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (1, 20, 'Hi! How can I assist you with that?');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (1, 1, 'Can you provide more details about the product?');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (1, 20, 'Sure! The product is made of high-quality materials and is durable.');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (1, 1, 'That sounds great! How much does it cost?');



-- Chat 2: Seller (2) -> Buyer (21) interaction
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (2, 2, 'Hello, thank you for your interest in my product.');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (2, 21, 'I would like to know if you offer discounts on bulk orders.');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (2, 2, 'Yes, we offer discounts depending on the quantity. How many are you planning to buy?');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (2, 21, 'I need 100 units. Could you let me know the price?');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (2, 2, 'For 100 units, I can offer a 10% discount. The total will be $900.');

-- Chat 3: Buyer (3) -> Seller (22) interaction
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (3, 3, 'Hi, I saw your listing online and wanted to ask if it’s still available.');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (3, 22, 'Hello! Yes, the item is still available. What would you like to know about it?');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (3, 3, 'Can I get a sample before I buy?');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (3, 22, 'Unfortunately, we don’t provide samples, but I can assure you the quality is excellent.');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (3, 3, 'I understand. How do I place an order?');

-- Chat 4: Seller (4) -> Buyer (23) interaction
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (4, 4, 'Good day! Are you interested in buying our product?');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (4, 23, 'Yes, I am. Could you tell me about the warranty?');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (4, 4, 'The product comes with a one-year warranty.');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (4, 23, 'Is it possible to extend the warranty for an additional year?');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (4, 4, 'Yes, you can extend the warranty for a small fee.');

-- Chat 5: Buyer (5) -> Seller (24) interaction
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (5, 5, 'Hey, I saw your ad. Can you tell me more about this product?');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (5, 24, 'Sure! It’s a high-end product with great features. What do you want to know?');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (5, 5, 'Is it available in different colors?');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (5, 24, 'Yes, it comes in red, blue, and black.');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (5, 5, 'I’m interested in the blue one. How do I purchase?');

-- Chat 6: Seller (6) -> Buyer (25) interaction
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (6, 6, 'Hi! I’m available to answer any questions about the product.');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (6, 25, 'Does the product come with free shipping?');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (6, 6, 'Yes, we offer free shipping for orders over $50.');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (6, 25, 'Great! Can you ship it to New York?');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (6, 6, 'Yes, we ship to New York. It’ll arrive in 3-5 business days.');

-- Chat 7: Buyer (7) -> Seller (26) interaction
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (7, 7, 'Hi, I’m looking for a similar product. Can you help me?');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (7, 26, 'Of course! What exactly are you looking for?');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (7, 7, 'I need something with more storage space.');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (7, 26, 'We have a variety of products with larger storage options. Would you like to see them?');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (7, 7, 'Yes, please show me the best options.');

-- Chat 8: Seller (8) -> Buyer (27) interaction
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (8, 8, 'Hello, thank you for showing interest in our product.');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (8, 27, 'I’m curious about the specifications of this product.');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (8, 8, 'It has a 4K display, 8GB RAM, and 256GB storage.');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (8, 27, 'Sounds great. Is there a return policy?');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (8, 8, 'Yes, we offer a 30-day return policy if you are not satisfied.');

-- Chat 9: Buyer (9) -> Seller (28) interaction
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (9, 9, 'I want to buy your product, but I need some more information.');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (9, 28, 'Sure! What additional information would you like?');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (9, 9, 'Can you tell me more about the payment options available?');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (9, 28, 'We accept credit cards, PayPal, and bank transfers.');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (9, 9, 'Perfect! I will make the payment today.');

-- Chat 1: Buyer (1) -> Seller (21) interaction
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (10, 1, 'Hello, I am interested in your product.');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (10, 21, 'Hi! How can I assist you with that?');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (10, 1, 'Can you provide more details about the product?');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (10, 21, 'Sure!');
INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (10, 1, 'That sounds great! How much does it cost?');

-- Inserting 10 chat sessions with different Sender and Receiver BuyerIDs and CurrentUser
INSERT INTO Chat (Sender, Reciver, CurrentUser) VALUES (1, 20, 'Buyer');
INSERT INTO Chat (Sender, Reciver, CurrentUser) VALUES (2, 21, 'Seller');
INSERT INTO Chat (Sender, Reciver, CurrentUser) VALUES (3, 22, 'Buyer');
INSERT INTO Chat (Sender, Reciver, CurrentUser) VALUES (4, 23, 'Seller');
INSERT INTO Chat (Sender, Reciver, CurrentUser) VALUES (5, 24, 'Buyer');
INSERT INTO Chat (Sender, Reciver, CurrentUser) VALUES (6, 25, 'Seller');
INSERT INTO Chat (Sender, Reciver, CurrentUser) VALUES (7, 26, 'Buyer');
INSERT INTO Chat (Sender, Reciver, CurrentUser) VALUES (8, 27, 'Seller');
INSERT INTO Chat (Sender, Reciver, CurrentUser) VALUES (9, 28, 'Buyer');
INSERT INTO Chat (Sender, Reciver, CurrentUser) VALUES (1, 21, 'Seller');

INSERT INTO Orders (GigID, SellerID, BuyerID, SellerReview, OrderStatus)
VALUES
-- Orders for Seller 1 (Appliance Technician)
(1, 2, 1, NULL, 'Pending')



INSERT INTO Orders (GigID, SellerID, BuyerID, SellerReview, OrderStatus)
VALUES
-- Orders for Seller 1 (Appliance Technician)
(1, 1, 20, NULL, 'Pending')

Select* from orders



Select sender from chat where chatid =  and currentUser = 'Buyer'

-- Inserting orders for each seller with different statuses, reviews only for completed orders
INSERT INTO Orders (GigID, SellerID, BuyerID, SellerReview, OrderStatus)
VALUES
-- Orders for Seller 1 (Appliance Technician)
(1, 1, 19, NULL, 'Active'),
(1, 1, 20, 4, 'Completed'),
(1, 1, 21, NULL, 'Pending'),
(1, 1, 22, NULL, 'In Progress'),
(1, 1, 23, 5, 'Completed'),

-- Orders for Seller 2 (Blacksmith)
(2, 2, 24, NULL, 'Active'),
(2, 2, 25, 5, 'Completed'),
(2, 2, 26, NULL, 'Pending'),
(2, 2, 27, NULL, 'In Progress'),
(2, 2, 28, 4, 'Completed'),

-- Orders for Seller 3 (Carpenter)
(3, 3, 19, 5, 'Completed'),
(3, 3, 20, NULL, 'Active'),
(3, 3, 21, NULL, 'In Progress'),
(3, 3, 22, NULL, 'Pending'),
(3, 3, 23, 4, 'Completed'),

-- Orders for Seller 4 (Chef/Cook)
(4, 4, 24, NULL, 'Pending'),
(4, 4, 25, 4, 'Completed'),
(4, 4, 26, NULL, 'In Progress'),
(4, 4, 27, NULL, 'Active'),
(4, 4, 28, 5, 'Completed'),

-- Orders for Seller 5 (Electrician)
(5, 5, 29, 4, 'Completed'),
(5, 5, 30, NULL, 'Active'),
(5, 5, 19, NULL, 'Pending'),
(5, 5, 20, NULL, 'In Progress'),
(5, 5, 21, 5, 'Completed'),

-- Orders for Seller 6 (Glass Worker)
(6, 6, 22, NULL, 'Pending'),
(6, 6, 23, NULL, 'Active'),
(6, 6, 24, 3, 'Completed'),
(6, 6, 25, NULL, 'In Progress'),
(6, 6, 26, 5, 'Completed'),

-- Orders for Seller 7 (Lock Smith)
(7, 7, 27, 5, 'Completed'),
(7, 7, 28, NULL, 'Pending'),
(7, 7, 29, NULL, 'Active'),
(7, 7, 30, NULL, 'In Progress'),
(7, 7, 19, 4, 'Completed'),

-- Orders for Seller 8 (Mechanic)
(8, 8, 20, NULL, 'In Progress'),
(8, 8, 21, 4, 'Completed'),
(8, 8, 22, NULL, 'Pending'),
(8, 8, 23, NULL, 'Active'),
(8, 8, 24, 5, 'Completed'),

-- Orders for Seller 9 (Mason)
(9, 9, 25, 4, 'Completed'),
(9, 9, 26, NULL, 'Active'),
(9, 9, 27, NULL, 'In Progress'),
(9, 9, 28, NULL, 'Pending'),
(9, 9, 29, 5, 'Completed'),

-- Orders for Seller 10 (Painter)
(10, 10, 30, NULL, 'In Progress'),
(10, 10, 19, NULL, 'Active'),
(10, 10, 20, 3, 'Completed'),
(10, 10, 21, NULL, 'Pending'),
(10, 10, 22, 4, 'Completed'),

-- Orders for Seller 11 (Plumber)
(11, 11, 23, 3, 'Completed'),
(11, 11, 24, NULL, 'Active'),
(11, 11, 25, NULL, 'In Progress'),
(11, 11, 26, NULL, 'Pending'),
(11, 11, 27, 4, 'Completed'),

-- Orders for Seller 12 (Pest Controller)
(12, 12, 28, 5, 'Completed'),
(12, 12, 29, NULL, 'In Progress'),
(12, 12, 30, NULL, 'Pending'),
(12, 12, 19, NULL, 'Active'),
(12, 12, 20, 5, 'Completed'),

-- Orders for Seller 13 (Plasterer)
(13, 13, 21, NULL, 'In Progress'),
(13, 13, 22, 4, 'Completed'),
(13, 13, 23, NULL, 'Pending'),
(13, 13, 24, NULL, 'Active'),
(13, 13, 25, 4, 'Completed'),

-- Orders for Seller 14 (Sewage Cleaner)
(14, 14, 26, 5, 'Completed'),
(14, 14, 27, NULL, 'Pending'),
(14, 14, 28, NULL, 'Active'),
(14, 14, 29, NULL, 'In Progress'),
(14, 14, 30, 4, 'Completed'),

-- Orders for Seller 15 (Technician)
(15, 15, 19, NULL, 'In Progress'),
(15, 15, 20, 4, 'Completed'),
(15, 15, 21, NULL, 'Pending'),
(15, 15, 22, NULL, 'Active'),
(15, 15, 23, 5, 'Completed'),

-- Orders for Seller 16 (Tiler)
(16, 16, 24, NULL, 'Pending'),
(16, 16, 25, 5, 'Completed'),
(16, 16, 26, NULL, 'In Progress'),
(16, 16, 27, NULL, 'Active'),
(16, 16, 28, 5, 'Completed'),

-- Orders for Seller 17 (Welder)
(17, 17, 29, 5, 'Completed'),
(17, 17, 30, NULL, 'In Progress'),
(17, 17, 19, NULL, 'Active'),
(17, 17, 20, NULL, 'Pending'),
(17, 17, 21, 4, 'Completed'),

-- Orders for Seller 18 (Furniture Repairer)
(18, 18, 22, NULL, 'Active'),
(18, 18, 23, 4, 'Completed'),
(18, 18, 24, NULL, 'Pending'),
(18, 18, 25, NULL, 'In Progress'),
(18, 18, 26, 4, 'Completed');



INSERT INTO Gig (GigDescription, SellerID)
VALUES 
('Experienced Appliance Technician with 5 years of expertise in diagnosing, repairing, and maintaining home appliances such as refrigerators, washing machines, and air conditioners. Dedicated to providing timely and reliable services.', 1),
('Skilled Blacksmith with 10 years of experience in forging, shaping, and repairing metal tools, gates, and ornamental pieces. Specializes in creating custom designs and durable metalwork for various needs.', 2),
('Professional Carpenter with 7 years of experience in crafting, assembling, and repairing wooden furniture, cabinets, and frameworks. Known for precision and high-quality finishes in all projects.', 3),
('Talented Chef/Cook with 8 years of culinary expertise in preparing delicious dishes across multiple cuisines, including continental, Asian, and traditional meals. Available for catering and event-specific menus.', 4),
('Certified Electrician with 6 years of hands-on experience in electrical installations, wiring, troubleshooting, and repair work. Ensures safety and compliance with all regulatory standards.', 5),
('Glass Worker with 4 years of experience in cutting, installing, and repairing glass for residential and commercial properties. Specializes in windows, shower enclosures, and decorative glass projects.', 6),
('Reliable Lock Smith with 9 years of expertise in repairing locks, duplicating keys, and installing advanced security systems. Offers emergency lockout services and security consultations.', 7),
('Proficient Mechanic with 10 years of experience in diagnosing and repairing cars, motorcycles, and other vehicles. Specializes in engine repairs, brake systems, and routine maintenance services.', 8),
('Seasoned Mason with 12 years of expertise in constructing and repairing brick walls, stone masonry, and concrete structures. Known for durable and aesthetically pleasing craftsmanship.', 9),
('Creative Painter with 5 years of experience in interior and exterior painting for homes, offices, and commercial spaces. Offers customized color consultations and detailed finishes.', 10),
('Expert Plumber with 8 years of experience in installing and repairing pipes, fixtures, and water systems. Specializes in both residential and commercial plumbing projects.', 11),
('Dedicated Pest Controller with 6 years of experience in eliminating and preventing pests such as termites, cockroaches, and rodents. Utilizes safe and eco-friendly methods.', 12),
('Skilled Plasterer with 7 years of experience in applying plaster to walls, ceilings, and decorative moldings. Known for smooth finishes and attention to detail in all projects.', 13),
('Efficient Sewage Cleaner with 5 years of experience in unclogging and maintaining sewer lines and drainage systems. Ensures hygiene and swift resolution of wastewater issues.', 14),
('Highly Skilled Technician with 6 years of experience in troubleshooting, maintaining, and repairing various electronic devices and machinery. Specializes in fast and effective solutions.', 15),
('Experienced Tiler with 9 years of expertise in installing and repairing floor and wall tiles for kitchens, bathrooms, and outdoor spaces. Offers custom designs and flawless finishes.', 16),
('Certified Welder with 8 years of experience in welding and fabricating metal structures, gates, and industrial equipment. Skilled in both MIG and TIG welding techniques.', 17),
('Expert Furniture Repairer with 7 years of experience in restoring antique furniture, repairing structural damage, and polishing wood to bring life back to valuable pieces.', 18);




-- Insert 18 sellers, each linked to a unique category with 12-digit CNICs
INSERT INTO Seller (SellerID, CNIC, CategoryID)
VALUES 
(1, '374061234561', 1),
(2, '374061234562', 2),
(3, '374061234563', 3),
(4, '374061234564', 4),
(5, '374061234565', 5),
(6, '374061234566', 6),
(7, '374061234567', 7),
(8, '374061234568', 8),
(9, '374061234569', 9),
(10, '374061234570', 10),
(11, '374061234571', 11),
(12, '374061234572', 12),
(13, '374061234573', 13),
(14, '374061234574', 14),
(15, '374061234575', 15),
(16, '374061234576', 16),
(17, '374061234577', 17),
(18, '374061234578', 18);




-- Inserting 18 categories into the Category table
INSERT INTO Category (CategoryType) VALUES
('Appliance Technician'),
('Blacksmith'),
('Carpenter'),
('Chef/Cook'),
('Electrician'),
('Glass Worker'),
('Lock Smith'),
('Mechanic'),
('Mason'),
('Painter'),
('Plumber'),
('Pest Controller'),
('Plasterer'),
('Sewage Cleaner'),
('Technician'),
('Tiler'),
('Welder'),
('Furniture Repairer');

-- Inserting 18 sellers && 12 Buyers
INSERT INTO Buyer (FNAME, LNAME, Username, Phone, BuyerLocation, Password) VALUES 
('Zara', 'Tariq', 'zaratariq14', '03321234567', 'Lahore', 'password123'),
('Arman', 'Qureshi', 'arman.qureshi15', '03421234567', 'Karachi', 'password123'),
('Farah', 'Ali', 'farahali16', '03521234567', 'Islamabad', 'password123'),
('Kashif', 'Ahmed', 'kashifahmed17', '03621234567', 'Lahore', 'password123'),
('Nida', 'Zafar', 'nidazafar18', '03721234567', 'Karachi', 'password123'),
('Umer', 'Hussain', 'umerhussain19', '03821234567', 'Islamabad', 'password123'),
('Sobia', 'Iqbal', 'sobiaiqbal20', '03921234567', 'Lahore', 'password123'),
('Fahad', 'Riaz', 'fahadriaz21', '03031234567', 'Karachi', 'password123'),
('Lubna', 'Ali', 'lubnaali22', '03131234567', 'Islamabad', 'password123'),
('Anwar', 'Shah', 'anwarshah23', '03231234567', 'Lahore', 'password123'),
('Ibrahim', 'Butt', 'ibrahimbutt24', '03331234567', 'Karachi', 'password123'),
('Emaan', 'Hassan', 'emaanhassan25', '03431234567', 'Islamabad', 'password123'),
('Hina', 'Malik', 'hinamalik26', '03531234567', 'Lahore', 'password123'),
('Taimoor', 'Ali', 'taimoorali27', '03631234567', 'Karachi', 'password123'),
('Rida', 'Ahmed', 'ridaahmed28', '03731234567', 'Islamabad', 'password123'),
('Faisal', 'Khan', 'faisalkhan29', '03831234567', 'Lahore', 'password123'),
('Kiran', 'Tariq', 'kirantariq30', '03931234567', 'Karachi', 'password123'),
('Zohaib', 'Younis', 'zohaibyounis31', '03041234567', 'Islamabad', 'password123'),
('Mehwish', 'Ahmed', 'mehwishahmed32', '03141234567', 'Lahore', 'password123'),
('Adeel', 'Rafiq', 'adeelrafiq33', '03241234567', 'Karachi', 'password123'),
('Hafsa', 'Shah', 'hafsashah34', '03341234567', 'Islamabad', 'password123'),
('Raheel', 'Khan', 'raheelkhan35', '03441234567', 'Lahore', 'password123'),
('Shiza', 'Malik', 'shizamalik36', '03541234567', 'Karachi', 'password123'),
('Nabeel', 'Ahmed', 'nabeelahmed37', '03641234567', 'Islamabad', 'password123'),
('Saad', 'Hassan', 'saadhassan38', '03741234567', 'Lahore', 'password123'),
('Yasmin', 'Tariq', 'yasmin.tariq39', '03841234567', 'Karachi', 'password123'),
('Osama', 'Qureshi', 'osamaqureshi40', '03941234567', 'Islamabad', 'password123'),
('Hiba', 'Ali', 'hibali41', '03051234567', 'Lahore', 'password123'),
('Dania', 'Ahmed', 'daniaahmed42', '03151234567', 'Karachi', 'password123'),
('Usama', 'Riaz', 'usamariaz43', '03251234567', 'Islamabad', 'password123');




