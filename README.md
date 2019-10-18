# address-book
Web application serving a RESTful API to perform operations on Organization and Users

Server port set to 8000.

Documentation : http://localhost:8000/swagger-ui.html
Also find postman collection.JSON in root folder, which you can import to try out the endpoints 

Organization:
id * PK
Name * unique
Address
Phone

User:
id * PK
First Name
Last Name
Email * unique
Address
Phone

Assosication [unique(userId, Organization)]  junction table
id * PK
userId *FK
organizationId  *FK


