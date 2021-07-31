

https://user-images.githubusercontent.com/77229948/127752453-c59bd138-dad6-4520-992f-0961a7a2ab94.mp4

# API Documentation

## GET `/hotels`

**Example Request**

`$ curl  http://somtohotelreservation-env-1.eba-ggtvx6ea.us-east-2.elasticbeanstalk.com/hotels`

**Example Response**

```json
[
    {
        "hotelId": 155207,
        "hotelName": "Ritz-Carlton Montréal",
        "price": 415,
        "availability": true
    },
    {
        "hotelId": 1063797,
        "hotelName": "Rosewood Hotel Georgia",
        "price": 437,
        "availability": true
    },
    {
        "hotelId": 1959496,
        "hotelName": "The Ritz-Carlton, Toronto",
        "price": 410,
        "availability": true
    },
    {
        "hotelId": 1485977,
        "hotelName": "Fairmont Pacific Rim",
        "price": 365,
        "availability": true
    }
]
```

## GET `/hotels/{id}`

**Example Request**

`$ curl  http://somtohotelreservation-env-1.eba-ggtvx6ea.us-east-2.elasticbeanstalk.com/hotels/155207`

**Example Response**

```json
{
    "hotelId": 155207,
    "hotelName": "Ritz-Carlton Montréal",
    "price": 415,
    "availability": true
}
```

## POST `/reservation`

**Example Request**

`$ curl  http://somtohotelreservation-env-1.eba-ggtvx6ea.us-east-2.elasticbeanstalk.com/reservation`

**Request Body**

```json
{
    "hotelName": "Wedgewood Hotel",
    "checkIn": "2021-07-07T20:00:00",
    "checkOut": "2021-07-27T20:00:00",
    "guestList": [
        {
            "firstName": "Bob",
            "lastName": "Marley",
            "gender": 0
        }
    ]
}
```

**Example Response**

```json
{
    "confirmationNumber": 8
}
```

## Error Handling

**Bad request (Incorrect ID)**

`$ curl  http://somtohotelreservation-env-1.eba-ggtvx6ea.us-east-2.elasticbeanstalk.com/hotels/1`

**Response**

`Could not find a hotel with ID: 1`

