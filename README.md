
# Patronus Case Study

This Android application uses an open API to fetch information about Device Holder Users and displays it in a list. When a user item is clicked, more information about that specific user is displayed. 

This Android application is developed using Jetpack Compose for the UI interface, which allows for a more flexible and efficient way of building user interfaces. The MVVM (Model-View-ViewModel) design pattern is utilized to keep the code readable and maintainable, separating the business logic from the presentation layer. This results in a cleaner and more scalable codebase.



## Authors

- [@hamzach330](https://github.com/hamzach330)


## API Reference

#### Github Repos

```
  BaseUrl
  https://api.code-challenge.patronus-group.com/
```

#### Get all Device Holder Users

```
  @GET
 https://api.code-challenge.patronus-group.com/users
```

#### Response Sample All Users 

```
  {
	"customers": [{
			"id": 1,
			"firstName": "John",
			"lastName": "Doe",
			"gender": "MALE",
			"phoneNumber": "123-456-7890",
			"imageUrl": "https://fastly.picsum.photos/id/473/200/300.jpg?hmac=WYG6etF60iOJeGoFVY1hVDMakbBRS32ZDGNkVZhF6-8",
			"stickers": ["Fam"]
		},
		{
			"id": 2,
			"firstName": "Jane",
			"lastName": "Doe",
			"gender": "FEMALE",
			"phoneNumber": "123-456-7891",
			"imageUrl": "https://fastly.picsum.photos/id/445/400/400.jpg?hmac=CCjqlZXQQ_5kl0X6naMjQKUWSbQloDYImyB9zGFOA8M",
			"stickers": ["Fam", "Ban"]
		},
		{
			"id": 3,
			"firstName": "Bob",
			"lastName": "Smith",
			"gender": "MALE",
			"phoneNumber": "123-456-7892",
			"imageUrl": null,
			"stickers": ["Ban"]
		},
		{
			"id": 4,
			"firstName": "Sally",
			"lastName": "Johnson",
			"gender": "FEMALE",
			"phoneNumber": "123-456-7893",
			"imageUrl": "https://fastly.picsum.photos/id/13/500/500.jpg?hmac=oIMjG56df3J3cWXHmJTmMSVj1huozLkKwY4NAUXpxOw",
			"stickers": ["Fam"]
		},
		{
			"id": 5,
			"firstName": "Mark",
			"lastName": "Davis",
			"gender": "MALE",
			"phoneNumber": "123-456-7894",
			"imageUrl": null,
			"stickers": ["Fam", "Ban"]
		},
		{
			"id": 6,
			"firstName": "Emily",
			"lastName": "Brown",
			"gender": "FEMALE",
			"phoneNumber": "123-456-7895",
			"imageUrl": "https://fastly.picsum.photos/id/628/400/400.jpg?hmac=uQnrWHhKS3XBUnJaTHJHb7TBhQX7uZ0p1q_Y2hLnEWY",
			"stickers": ["Fam"]
		},
		{
			"id": 7,
			"firstName": "David",
			"lastName": "Wilson",
			"gender": "MALE",
			"phoneNumber": "123-456-7896",
			"imageUrl": null,
			"stickers": ["Ban"]
		},
		{
			"id": 8,
			"firstName": "Olivia",
			"lastName": "Garcia",
			"gender": "FEMALE",
			"phoneNumber": "123-456-7897",
			"imageUrl": "https://fastly.picsum.photos/id/650/400/400.jpg?hmac=aRSRZFa8j3OPfCyAkMVThCXyRqSK-GhyPHmkcZscOC8",
			"stickers": ["Fam"]
		},
		{
			"id": 9,
			"firstName": "Daniel",
			"lastName": "Martinez",
			"gender": "MALE",
			"phoneNumber": "123-456-5910",
			"imageUrl": null,
			"stickers": ["Ban"]
		},
		{
			"id": 10,
			"firstName": "Sophia",
			"lastName": "Lopez",
			"gender": "FEMALE",
			"phoneNumber": "123-456-1212",
			"imageUrl": "https://example.com/sophia.jpg",
			"stickers": ["Fam", "Ban"]
		},
		{
			"id": 11,
			"firstName": "Dave",
			"lastName": "Thompson",
			"gender": "MALE",
			"phoneNumber": "123-456-3322",
			"imageUrl": "https://fastly.picsum.photos/id/237/200/300.jpg?hmac=TmmQSbShHz9CdQm0NkEjx1Dyh_Y984R9LpNrpvH2D_U",
			"stickers": ["Fam", "Ban"]
		},
		{
			"id": 12,
			"firstName": "Federico",
			"lastName": "Santana",
			"gender": "MALE",
			"phoneNumber": "123-456-7789",
			"imageUrl": null,
			"stickers": ["Ban"]
		},
		{
			"id": 13,
			"firstName": "Joell",
			"lastName": "Ortiz",
			"gender": "MALE",
			"phoneNumber": "123-456-5555",
			"imageUrl": null,
			"stickers": ["Fam", "Ban"]
		},
		{
			"id": 14,
			"firstName": "Mery",
			"lastName": "Stan",
			"gender": "FEMALE",
			"phoneNumber": "123-456-4244",
			"imageUrl": null,
			"stickers": ["Fam", "Ban"]
		},
		{
			"id": 15,
			"firstName": "Daniel",
			"lastName": "Wood",
			"gender": "FEMALE",
			"phoneNumber": "123-313-7898",
			"imageUrl": null,
			"stickers": ["Fam", "Ban"]
		},
		{
			"id": 16,
			"firstName": "Daniel",
			"lastName": "Forrest",
			"gender": "FEMALE",
			"phoneNumber": "123-313-3132",
			"imageUrl": null,
			"stickers": ["Ban"]
		},
		{
			"id": 17,
			"firstName": "Anna",
			"lastName": "Rose",
			"gender": "FEMALE",
			"phoneNumber": "123-999-5555",
			"imageUrl": null,
			"stickers": ["Fam", "Ban"]
		},
		{
			"id": 18,
			"firstName": "Jessica",
			"lastName": "Bangladesh",
			"gender": "FEMALE",
			"phoneNumber": "123-313-4589",
			"imageUrl": null,
			"stickers": ["Ban"]
		},
		{
			"id": 19,
			"firstName": "Michael",
			"lastName": "Johnson",
			"gender": "MALE",
			"phoneNumber": "123-987-4241",
			"imageUrl": null,
			"stickers": ["Ban"]
		},
		{
			"id": 20,
			"firstName": "John",
			"lastName": "Michael",
			"gender": "MALE",
			"phoneNumber": "123-313-6665",
			"imageUrl": null,
			"stickers": ["Ban"]
		}
	]
}
```


#### Get User By ID

```
  @GET 
  https://api.code-challenge.patronus-group.com/users/{userId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId`  | `string` | **Required**. Where userId is JSON|
|           |          | "login" feild of each user from   |
|           |          | previous request/response         |



#### Response Sample Get Device Holder User By ID

```
{
	"id": 11,
	"imageUrl": "https://fastly.picsum.photos/id/237/200/300.jpg?hmac=TmmQSbShHz9CdQm0NkEjx1Dyh_Y984R9LpNrpvH2D_U",
	"currentLatitude": 37.7749,
	"currentLongitude": -122.4194,
	"firstName": "Dave",
	"lastName": "Thompson",
	"stickers": ["Fam","Ban"],
	"gender": "MALE",
	"phoneNumber": "123-456-3322",
	"address": {
		"street": "123 Main St",
		"city": "San Francisco",
		"state": "CA",
		"zip": "94111",
		"country": "USA"
	}
}
```
## Documentation

#### Design Pattern

Model-View-ViewModel (ie MVVM) is the template used in this application Architecture Design, 
proposed by John Gossman as an alternative to MVC and MVP patterns. Its concept is 
to separate data presentation logic from business logic by moving it into 
particular class for a clear distinction.


#### Why Promoting MVVM VS MVP/MVC/MVP:

- ViewModel has Built in LifeCycleOwerness, on the other hand Presenter 
    not, and you have to take this responsiblty in your side. 
- ViewModel doesn't have a reference for View, on the other hand Presenter
    still hold a reference for view, even if you made it as weakreference.
- ViewModel survive configuration changes, while it is your own 
    responsiblities to survive the configuration changes in case of
    Presenter. (Saving and restoring the UI state)

#### MVVM Best Pratice:

- Avoided references to Views in ViewModels.
- Instead of pushing data to the UI, observed changes to it.
- Distribute responsibilities, add a domain layer if needed.
- Add a data repository as the single-point entry to your data.
- Expose information about the state of your data using a wrapper or a state change 
    event manager.
- Consider edge cases, leaks and how long-running operations can affect 
    the instances in your architecture.
- Don’t put logic in the ViewModel that is critical to saving clean state 
    or related to data. Any call you make from a ViewModel can be the last one.
- Added an additional layer containg the UseCase for the Application, This layer can 
    be added at feature level or app level as per the requirement. 


#### Best Pratices used in the app development:

- Used Kotlin Coroutines as threads for asynchronous programming, 
    Coroutines not only open the doors to asynchronous programming, but also provide
    a wealth of other possibilities such as concurrency, actors, etc.

- Used Jetpack Compose is a modern toolkit that allows us to build our screens in a declarative approach writing less code. Android UI Development is now more powerful and more decoupled.

- Used Navigation with Compose this navigation component provides support for Jetpack Compose applications. You can navigate between composables while taking advantage of the Navigation component’s infrastructure and features.

- Used JUnit - Suite Test, Test suite is used to bundle a few unit test cases and run them together.




