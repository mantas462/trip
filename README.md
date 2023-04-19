# Trip application

#### Requirements

Labas,
mano vardas Tadas. Aš turiu draugą Matą, kuris yra užkietėjęs keliautojas pėsčiomis. Viskas, ką jis pasiima į kelionę, yra jo šuo Uoga ir
jo kuprinė. Kuprinė būna prigrūsta visokių niekniekių, todėl jam dažnai tenka keliauti tuščiu pilvu. Matas pakvietė mane į 100 km žygį
pėsčiomis. Aš visiškai nenutuokiu, kokių daiktų ir kiek reikėtų pasiimti į šį žygį. Todėl man reikalinga Tavo pagalba. Reikėtų universalios
programėlės/skripto ar ko nors panašaus, kad, įvedęs kilometrų skaičių ir kitą reikalingą informaciją, aš galėčiau gauti kelionei reikalingų
daiktų ir jų kiekių sąrašą. Turbūt pats supranti, kad kelionės metu reikės maitintis, o jei kilometrų skaičius bus didelis, ir kur nors
nakvoti. Be to, programėlė galėtų atsižvelgti ir į metų laiką – vasarą gal reikėtų nepamiršti kepurės nuo saulės, o rudenį skėčio.
Techninių reikalavimų nėra. Visiška laisvė. Jei Tu programuoji front-end technologijomis, rezultatas gali būti web puslapis.
Jei Tu programuoji back-end technologijomis, rezultatas gali būti endpoint'as, kuris priimtų kilometrų skaičių ir kitą reikalingą informaciją,
o atsakymą grąžintų JSON formatu. Jei pasirinksi rašyti skriptą, pirmyn. Jei Tau patinka duomenų bazės, gali panaudoti ir jas. Svarbu tik,
kad galėčiau įvesti pradinius duomenis ir suprasčiau atsakymą.

#### Requirements implementation
The system has a limit of 20 km per day, meaning that if a person travels more than 20 km, the trip will extend beyond one day.
The system provides three meals, two sets of clothing, and one set of gear per day, selected according to the season. For example, during the summer, the system might provide watermelon, ice cream, an umbrella, and sunglasses, while during the winter, it might provide a snow shovel, a windbreaker, and hot chocolate.

E.g. request:
`{
"tripLength": 20,
"seasonTypeDto": "SUMMER"
}`
Explanation: we ask system for a food, wear and gear for 1 day during the summer time.

Response:
`"itemNameList": [
"Banana",
"Water",
"Coca-cola",
"Shirt",
"Dress",
"Umbrella"
]`
Explanation: we got planned food, wear and gear for the summer time.


E.g. request:
`{
"tripLength": 21,
"seasonTypeDto": "WINTER"
}`
Explanation: we ask system for a food, wear and gear for 2 days during the winter time.

Response:
`"itemNameList": [
"Banana",
"Water",
"Coca-cola",
"Orange",
"Corn",
"Milk",
"Sweatshirt",
"Jacket",
"Warm sweater",
"Windbreaker",
"Shovel"
]`
Explanation: we got planned food, wear and gear for the winter time.

#### Technology stack

- Java 17
- Spring
- Maven
- H2 memory database
- JPA with Hibernate
- Lombok
- ...

#### Description of implementation structure

The implementation was done in one microservice with the standard layered structure of it: controller, service and DAO. Microservice has 2 different endpoints for different purposes: to save itme list and to plan a trip. Each controller is responsible for communication with external applications. Each service is responsible for business logic. Each DAO is responsible to retrieve data from database.

#### Launch requirements

- Internet
- JDK - to run Java application
- Maven - to download dependencies

#### How to launch

- Launch `TripApplication`

#### Application access links

- Database access link: http://localhost:8080/h2-console (username: sa, password: password)
- Postman collections link for testing purposes: https://github.com/mantas462/trip-postman-collection
- Access links of endpoints:
    - Plan trip: http://localhost:8080/api/v1/trip
    - Save item list: http://localhost:8080/api/v1/item

#### Improvements needed for application

- Improve planning functionality
- Make endpoints secure and not accessible by everyone
- Add real database
- Add logging functionality to the classes
- Complete postman collections with all cases
- Remove Spring Data JPA and have querying API like dslContext
- Add Swagger-UI
- Add tests
- ...
