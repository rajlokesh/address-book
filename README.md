# address-book
Web application serving a RESTful API to perform operations on Organization and Users

Server port set to 8000.

Documentation : http://localhost:8000/swagger-ui.html
Also find postman collection.JSON in root folder, which you can import to try out the endpoints 

Organization:
<br />id * PK
<br />Name * unique
<br />Address
<br />Phone

User:
<br />id * PK
<br />First Name
<br />Last Name
<br />Email * unique
<br />Address
<br />Phone

Assosication [unique(userId, Organization)]  junction table
<br />id * PK
<br />userId *FK
<br />organizationId  *FK


