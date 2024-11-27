drop procedure GetUserUniqueChatsWithOppositeUser
CREATE PROCEDURE GetUserUniqueChatsWithOppositeUser
    @UserId INT
AS
BEGIN
    SELECT DISTINCT 
        c.ChatID,
        CASE 
            WHEN c.Sender = @UserId THEN c.Reciver
            WHEN c.Reciver = @UserId THEN c.Sender
        END AS OppositeUserID,
        CASE 
            WHEN c.Sender = @UserId THEN CONCAT(b2.FNAME, ' ', b2.LNAME) -- Name of the Reciver
            WHEN c.Reciver = @UserId THEN CONCAT(b1.FNAME, ' ', b1.LNAME) -- Name of the Sender
        END AS OppositeUserName
    FROM Chat c
    LEFT JOIN Buyer b1 ON c.Sender = b1.BuyerID
    LEFT JOIN Buyer b2 ON c.Reciver = b2.BuyerID
    WHERE c.Sender = @UserId OR c.Reciver = @UserId;
END;

EXEC GetUserUniqueChatsWithOppositeUser @UserId = 1;


CREATE PROCEDURE GetUserChatIDs
    @UserId INT
AS
BEGIN
    SELECT  
        c.ChatID
    FROM Chat c
    WHERE c.Sender = @UserId OR c.Reciver = @UserId;
END;

-- Execute the procedure
EXEC GetUserChatIDs @UserId = 1;

-------------------------------------------------------------------

CREATE PROCEDURE GetChatMessagesWithSender
    @ChatID INT,
    @UserID INT
AS
BEGIN
    -- Return all messages in the chat along with the sender's ID
    SELECT 
        cm.MessageID,
        cm.MessageDescription,
        cm.Timestamp,
        cm.Sender
    FROM ChatMessages cm
    WHERE cm.ChatID = @ChatID
    ORDER BY cm.Timestamp ASC; -- Messages are ordered by timestamp
END;

EXEC GetChatMessagesWithSender @ChatID = 1, @UserID = 2;
