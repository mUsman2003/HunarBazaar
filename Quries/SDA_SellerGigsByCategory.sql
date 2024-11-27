Select * from Category
select* from seller
select* from buyer
CALL ApplianceTechnicianGig;
-- Call the ApplianceTechnicianGig procedure	
EXEC ApplianceTechnicianGig;
-- Call the BlacksmithGig procedure
EXEC BlacksmithGig;
-- Call the CarpenterGig procedure
EXEC CarpenterGig;
-- Call the ChefGig procedure
EXEC ChefGig;
-- Call the ElectricianGig procedure
EXEC ElectricianGig;
-- Call the GlassworkerGig procedure
EXEC GlassworkerGig;
-- Call the LockSmithGig procedure
EXEC LockSmithGig;
-- Call the MechanicGig procedure
EXEC MechanicGig;
-- Call the MasonGig procedure
EXEC MasonGig;
-- Call the PainterGig procedure
EXEC PainterGig;
-- Call the PestControllerGig procedure
EXEC PestControllerGig;
-- Call the PlumberGig procedure
EXEC PlumberGig;
-- Call the PlastererGig procedure
EXEC PlastererGig;
-- Call the SewageCleanerGig procedure
EXEC SewageCleanerGig;
-- Call the TechnicianGig procedure
EXEC TechnicianGig;
-- Call the TilerGig procedure
EXEC TilerGig;
-- Call the WelderGig procedure
EXEC WelderGig;
-- Call the WoodworkerGig procedure
EXEC FurnitreRepairerGig;





--------------------------------------------------------------------------------------------------------------------

CREATE PROCEDURE ApplianceTechnicianGig
AS
BEGIN
	SELECT 
        b.FNAME + ' ' + b.LNAME AS SellerName,
        b.BuyerLocation AS SellerLocation,
        ROUND(AVG(CAST(o.SellerReview AS FLOAT)), 2) AS AvgSellerReview,
        g.GigDescription,
        c.CategoryType AS Category
    FROM 
        Orders o
    JOIN 
        Seller s ON o.SellerID = s.SellerID
    JOIN 
        Buyer b ON s.SellerID = b.BuyerID
    JOIN 
        Gig g ON o.GigID = g.GigID
    JOIN 
        Category c ON s.CategoryID = c.CategoryID
    WHERE 
        o.OrderStatus = 'Completed' AND s.CategoryID = 1 -- Filter for sellers in Category 1 (Appliance Technician)
    GROUP BY 
        b.FNAME, b.LNAME, b.BuyerLocation, g.GigDescription, c.CategoryType
    ORDER BY 
        AvgSellerReview DESC;
END;

CREATE PROCEDURE BlacksmithGig
AS
BEGIN
	SELECT 
        b.FNAME + ' ' + b.LNAME AS SellerName,
        b.BuyerLocation AS SellerLocation,
        ROUND(AVG(CAST(o.SellerReview AS FLOAT)), 2) AS AvgSellerReview,
        g.GigDescription,
        c.CategoryType AS Category
    FROM 
        Orders o
    JOIN 
        Seller s ON o.SellerID = s.SellerID
    JOIN 
        Buyer b ON s.SellerID = b.BuyerID
    JOIN 
        Gig g ON o.GigID = g.GigID
    JOIN 
        Category c ON s.CategoryID = c.CategoryID
    WHERE 
        o.OrderStatus = 'Completed' AND s.CategoryID = 2 
    GROUP BY 
        b.FNAME, b.LNAME, b.BuyerLocation, g.GigDescription, c.CategoryType
    ORDER BY 
        AvgSellerReview DESC;
END;

CREATE PROCEDURE CarpenterGig
AS
BEGIN
	SELECT 
        b.FNAME + ' ' + b.LNAME AS SellerName,
        b.BuyerLocation AS SellerLocation,
        ROUND(AVG(CAST(o.SellerReview AS FLOAT)), 2) AS AvgSellerReview,
        g.GigDescription,
        c.CategoryType AS Category
    FROM 
        Orders o
    JOIN 
        Seller s ON o.SellerID = s.SellerID
    JOIN 
        Buyer b ON s.SellerID = b.BuyerID
    JOIN 
        Gig g ON o.GigID = g.GigID
    JOIN 
        Category c ON s.CategoryID = c.CategoryID
    WHERE 
        o.OrderStatus = 'Completed' AND s.CategoryID = 3
    GROUP BY 
        b.FNAME, b.LNAME, b.BuyerLocation, g.GigDescription, c.CategoryType
    ORDER BY 
        AvgSellerReview DESC;
END;

CREATE PROCEDURE ChefGig
AS
BEGIN
	SELECT 
        b.FNAME + ' ' + b.LNAME AS SellerName,
        b.BuyerLocation AS SellerLocation,
        ROUND(AVG(CAST(o.SellerReview AS FLOAT)), 2) AS AvgSellerReview,
        g.GigDescription,
        c.CategoryType AS Category
    FROM 
        Orders o
    JOIN 
        Seller s ON o.SellerID = s.SellerID
    JOIN 
        Buyer b ON s.SellerID = b.BuyerID
    JOIN 
        Gig g ON o.GigID = g.GigID
    JOIN 
        Category c ON s.CategoryID = c.CategoryID
    WHERE 
        o.OrderStatus = 'Completed' AND s.CategoryID = 4
    GROUP BY 
        b.FNAME, b.LNAME, b.BuyerLocation, g.GigDescription, c.CategoryType
    ORDER BY 
        AvgSellerReview DESC;
END;

CREATE PROCEDURE ElectricianGig
AS
BEGIN
	SELECT 
        b.FNAME + ' ' + b.LNAME AS SellerName,
        b.BuyerLocation AS SellerLocation,
        ROUND(AVG(CAST(o.SellerReview AS FLOAT)), 2) AS AvgSellerReview,
        g.GigDescription,
        c.CategoryType AS Category
    FROM 
        Orders o
    JOIN 
        Seller s ON o.SellerID = s.SellerID
    JOIN 
        Buyer b ON s.SellerID = b.BuyerID
    JOIN 
        Gig g ON o.GigID = g.GigID
    JOIN 
        Category c ON s.CategoryID = c.CategoryID
    WHERE 
        o.OrderStatus = 'Completed' AND s.CategoryID = 5
    GROUP BY 
        b.FNAME, b.LNAME, b.BuyerLocation, g.GigDescription, c.CategoryType
    ORDER BY 
        AvgSellerReview DESC;
END;

CREATE PROCEDURE GlassworkerGig
AS
BEGIN
	SELECT 
        b.FNAME + ' ' + b.LNAME AS SellerName,
        b.BuyerLocation AS SellerLocation,
        ROUND(AVG(CAST(o.SellerReview AS FLOAT)), 2) AS AvgSellerReview,
        g.GigDescription,
        c.CategoryType AS Category
    FROM 
        Orders o
    JOIN 
        Seller s ON o.SellerID = s.SellerID
    JOIN 
        Buyer b ON s.SellerID = b.BuyerID
    JOIN 
        Gig g ON o.GigID = g.GigID
    JOIN 
        Category c ON s.CategoryID = c.CategoryID
    WHERE 
        o.OrderStatus = 'Completed' AND s.CategoryID = 6
    GROUP BY 
        b.FNAME, b.LNAME, b.BuyerLocation, g.GigDescription, c.CategoryType
    ORDER BY 
        AvgSellerReview DESC;
END;

CREATE PROCEDURE LockSmithGig
AS
BEGIN
	SELECT 
        b.FNAME + ' ' + b.LNAME AS SellerName,
        b.BuyerLocation AS SellerLocation,
        ROUND(AVG(CAST(o.SellerReview AS FLOAT)), 2) AS AvgSellerReview,
        g.GigDescription,
        c.CategoryType AS Category
    FROM 
        Orders o
    JOIN 
        Seller s ON o.SellerID = s.SellerID
    JOIN 
        Buyer b ON s.SellerID = b.BuyerID
    JOIN 
        Gig g ON o.GigID = g.GigID
    JOIN 
        Category c ON s.CategoryID = c.CategoryID
    WHERE 
        o.OrderStatus = 'Completed' AND s.CategoryID = 7
    GROUP BY 
        b.FNAME, b.LNAME, b.BuyerLocation, g.GigDescription, c.CategoryType
    ORDER BY 
        AvgSellerReview DESC;
END;

CREATE PROCEDURE MechanicGig
AS
BEGIN
	SELECT 
        b.FNAME + ' ' + b.LNAME AS SellerName,
        b.BuyerLocation AS SellerLocation,
        ROUND(AVG(CAST(o.SellerReview AS FLOAT)), 2) AS AvgSellerReview,
        g.GigDescription,
        c.CategoryType AS Category
    FROM 
        Orders o
    JOIN 
        Seller s ON o.SellerID = s.SellerID
    JOIN 
        Buyer b ON s.SellerID = b.BuyerID
    JOIN 
        Gig g ON o.GigID = g.GigID
    JOIN 
        Category c ON s.CategoryID = c.CategoryID
    WHERE 
        o.OrderStatus = 'Completed' AND s.CategoryID = 8
    GROUP BY 
        b.FNAME, b.LNAME, b.BuyerLocation, g.GigDescription, c.CategoryType
    ORDER BY 
        AvgSellerReview DESC;
END;

CREATE PROCEDURE MasonGig
AS
BEGIN
	SELECT 
        b.FNAME + ' ' + b.LNAME AS SellerName,
        b.BuyerLocation AS SellerLocation,
        ROUND(AVG(CAST(o.SellerReview AS FLOAT)), 2) AS AvgSellerReview,
        g.GigDescription,
        c.CategoryType AS Category
    FROM 
        Orders o
    JOIN 
        Seller s ON o.SellerID = s.SellerID
    JOIN 
        Buyer b ON s.SellerID = b.BuyerID
    JOIN 
        Gig g ON o.GigID = g.GigID
    JOIN 
        Category c ON s.CategoryID = c.CategoryID
    WHERE 
        o.OrderStatus = 'Completed' AND s.CategoryID = 9
    GROUP BY 
        b.FNAME, b.LNAME, b.BuyerLocation, g.GigDescription, c.CategoryType
    ORDER BY 
        AvgSellerReview DESC;
END;

CREATE PROCEDURE PainterGig
AS
BEGIN
	SELECT 
        b.FNAME + ' ' + b.LNAME AS SellerName,
        b.BuyerLocation AS SellerLocation,
        ROUND(AVG(CAST(o.SellerReview AS FLOAT)), 2) AS AvgSellerReview,
        g.GigDescription,
        c.CategoryType AS Category
    FROM 
        Orders o
    JOIN 
        Seller s ON o.SellerID = s.SellerID
    JOIN 
        Buyer b ON s.SellerID = b.BuyerID
    JOIN 
        Gig g ON o.GigID = g.GigID
    JOIN 
        Category c ON s.CategoryID = c.CategoryID
    WHERE 
        o.OrderStatus = 'Completed' AND s.CategoryID = 10
    GROUP BY 
        b.FNAME, b.LNAME, b.BuyerLocation, g.GigDescription, c.CategoryType
    ORDER BY 
        AvgSellerReview DESC;
END;

CREATE PROCEDURE PestControllerGig
AS
BEGIN
	SELECT 
        b.FNAME + ' ' + b.LNAME AS SellerName,
        b.BuyerLocation AS SellerLocation,
        ROUND(AVG(CAST(o.SellerReview AS FLOAT)), 2) AS AvgSellerReview,
        g.GigDescription,
        c.CategoryType AS Category
    FROM 
        Orders o
    JOIN 
        Seller s ON o.SellerID = s.SellerID
    JOIN 
        Buyer b ON s.SellerID = b.BuyerID
    JOIN 
        Gig g ON o.GigID = g.GigID
    JOIN 
        Category c ON s.CategoryID = c.CategoryID
    WHERE 
        o.OrderStatus = 'Completed' AND s.CategoryID = 12
    GROUP BY 
        b.FNAME, b.LNAME, b.BuyerLocation, g.GigDescription, c.CategoryType
    ORDER BY 
        AvgSellerReview DESC;
END;

CREATE PROCEDURE PlumberGig
AS
BEGIN
    SELECT 
        b.FNAME + ' ' + b.LNAME AS SellerName,
        b.BuyerLocation AS SellerLocation,
        ROUND(AVG(CAST(o.SellerReview AS FLOAT)), 2) AS AvgSellerReview,
        g.GigDescription,
        c.CategoryType AS Category
    FROM 
        Orders o
    JOIN 
        Seller s ON o.SellerID = s.SellerID
    JOIN 
        Buyer b ON s.SellerID = b.BuyerID
    JOIN 
        Gig g ON o.GigID = g.GigID
    JOIN 
        Category c ON s.CategoryID = c.CategoryID
    WHERE 
        o.OrderStatus = 'Completed' AND s.CategoryID = 11
    GROUP BY 
        b.FNAME, b.LNAME, b.BuyerLocation, g.GigDescription, c.CategoryType
    ORDER BY 
        AvgSellerReview DESC;
END;

CREATE PROCEDURE PlastererGig
AS
BEGIN
	SELECT 
        b.FNAME + ' ' + b.LNAME AS SellerName,
        b.BuyerLocation AS SellerLocation,
        ROUND(AVG(CAST(o.SellerReview AS FLOAT)), 2) AS AvgSellerReview,
        g.GigDescription,
        c.CategoryType AS Category
    FROM 
        Orders o
    JOIN 
        Seller s ON o.SellerID = s.SellerID
    JOIN 
        Buyer b ON s.SellerID = b.BuyerID
    JOIN 
        Gig g ON o.GigID = g.GigID
    JOIN 
        Category c ON s.CategoryID = c.CategoryID
    WHERE 
        o.OrderStatus = 'Completed' AND s.CategoryID = 13
    GROUP BY 
        b.FNAME, b.LNAME, b.BuyerLocation, g.GigDescription, c.CategoryType
    ORDER BY 
        AvgSellerReview DESC;
END;

CREATE PROCEDURE SewageCleanerGig
AS
BEGIN
	SELECT 
        b.FNAME + ' ' + b.LNAME AS SellerName,
        b.BuyerLocation AS SellerLocation,
        ROUND(AVG(CAST(o.SellerReview AS FLOAT)), 2) AS AvgSellerReview,
        g.GigDescription,
        c.CategoryType AS Category
    FROM 
        Orders o
    JOIN 
        Seller s ON o.SellerID = s.SellerID
    JOIN 
        Buyer b ON s.SellerID = b.BuyerID
    JOIN 
        Gig g ON o.GigID = g.GigID
    JOIN 
        Category c ON s.CategoryID = c.CategoryID
    WHERE 
        o.OrderStatus = 'Completed' AND s.CategoryID = 14
    GROUP BY 
        b.FNAME, b.LNAME, b.BuyerLocation, g.GigDescription, c.CategoryType
    ORDER BY 
        AvgSellerReview DESC;
END;

CREATE PROCEDURE TechnicianGig
AS
BEGIN
	SELECT 
        b.FNAME + ' ' + b.LNAME AS SellerName,
        b.BuyerLocation AS SellerLocation,
        ROUND(AVG(CAST(o.SellerReview AS FLOAT)), 2) AS AvgSellerReview,
        g.GigDescription,
        c.CategoryType AS Category
    FROM 
        Orders o
    JOIN 
        Seller s ON o.SellerID = s.SellerID
    JOIN 
        Buyer b ON s.SellerID = b.BuyerID
    JOIN 
        Gig g ON o.GigID = g.GigID
    JOIN 
        Category c ON s.CategoryID = c.CategoryID
    WHERE 
        o.OrderStatus = 'Completed' AND s.CategoryID = 15
    GROUP BY 
        b.FNAME, b.LNAME, b.BuyerLocation, g.GigDescription, c.CategoryType
    ORDER BY 
        AvgSellerReview DESC;
END;

CREATE PROCEDURE TilerGig
AS
BEGIN
	SELECT 
        b.FNAME + ' ' + b.LNAME AS SellerName,
        b.BuyerLocation AS SellerLocation,
        ROUND(AVG(CAST(o.SellerReview AS FLOAT)), 2) AS AvgSellerReview,
        g.GigDescription,
        c.CategoryType AS Category
    FROM 
        Orders o
    JOIN 
        Seller s ON o.SellerID = s.SellerID
    JOIN 
        Buyer b ON s.SellerID = b.BuyerID
    JOIN 
        Gig g ON o.GigID = g.GigID
    JOIN 
        Category c ON s.CategoryID = c.CategoryID
    WHERE 
        o.OrderStatus = 'Completed' AND s.CategoryID = 16
    GROUP BY 
        b.FNAME, b.LNAME, b.BuyerLocation, g.GigDescription, c.CategoryType
    ORDER BY 
        AvgSellerReview DESC;
END;

CREATE PROCEDURE WelderGig
AS
BEGIN
	SELECT 
        b.FNAME + ' ' + b.LNAME AS SellerName,
        b.BuyerLocation AS SellerLocation,
        ROUND(AVG(CAST(o.SellerReview AS FLOAT)), 2) AS AvgSellerReview,
        g.GigDescription,
        c.CategoryType AS Category
    FROM 
        Orders o
    JOIN 
        Seller s ON o.SellerID = s.SellerID
    JOIN 
        Buyer b ON s.SellerID = b.BuyerID
    JOIN 
        Gig g ON o.GigID = g.GigID
    JOIN 
        Category c ON s.CategoryID = c.CategoryID
    WHERE 
        o.OrderStatus = 'Completed' AND s.CategoryID = 17
    GROUP BY 
        b.FNAME, b.LNAME, b.BuyerLocation, g.GigDescription, c.CategoryType
    ORDER BY 
        AvgSellerReview DESC;
END;

CREATE PROCEDURE FurnitreRepairerGig
AS
BEGIN
	SELECT 
        b.FNAME + ' ' + b.LNAME AS SellerName,
        b.BuyerLocation AS SellerLocation,
        ROUND(AVG(CAST(o.SellerReview AS FLOAT)), 2) AS AvgSellerReview,
        g.GigDescription,
        c.CategoryType AS Category
    FROM 
        Orders o
    JOIN 
        Seller s ON o.SellerID = s.SellerID
    JOIN 
        Buyer b ON s.SellerID = b.BuyerID
    JOIN 
        Gig g ON o.GigID = g.GigID
    JOIN 
        Category c ON s.CategoryID = c.CategoryID
    WHERE 
        o.OrderStatus = 'Completed' AND s.CategoryID = 18
    GROUP BY 
        b.FNAME, b.LNAME, b.BuyerLocation, g.GigDescription, c.CategoryType
    ORDER BY 
        AvgSellerReview DESC;
END;