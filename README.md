# Social Distance #

BitBucket URL : https://derEntwickler007@bitbucket.org/derEntwickler007/social-distance.git

1.Request for Add New User:

                 Method: POST
                 Postman URL: http://localhost:8080/user/save
                 Request Body: 
							{  
								"firstName":"Ram",
								"lastName":"Kshire",
								"mobileNo":"8080756412",
								"emailId":"ram@ujwal.com",
								"city":"Dhule",
								"friends":[]
							}
2.Request for Add New User Friend  :

                  Method: POST
                  Postman URL: http://localhost:8080/user/userFriendRequest
                  Request Body: 
                            {
									"userId":1,
									"friendId":3
                            }
3.Request for Get All Friends :

                  Method: Get
                  Postman URL: http://localhost:8080/user/getUserFriendList?id=6
                  Request Param: "id":6
4.Request for Remove User Friend :

                  Method: POST
                  Postman URL: http://localhost:8080/user/removeUserFriend
                  Request Body: 
                              {
									"userId":1,
									"friendId":3
							   }
