# Learning Backend Dev

Backend Project for a Mobile and Web Programming Project
The goal is to build an application which will able to
manage a building windows:

- the building has an outside temperature,
and rooms.
- each room has zero or more heaters, has
zero or more windows, a name, a floor, a
current temperature, a target temperature.
- each heater has a name, an on or off
status, possibly a power.
- each window has a name, an a status
open or closed.

This Backend is a Spring application with an embedded database deployed on Clever Cloud with a REST client. This backend is called by a Website (https://github.com/Aboussejra/faircorp_web_frontend) and an android app (https://github.com/Aboussejra/faircorp_android_frontend)

Backend is as of December 2021 deployed on clever cloud and one may look at the exposed Rest API here :
https://boussejra.amir.faircorp.cleverapps.io/swagger-ui/index.html
