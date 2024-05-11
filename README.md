# Cost Splitter API

## Overview

__Cost Splitter__ is a *RESTful API* designed to manage events and associated debts, enabling users to effortlessly split bills among participants. This API provides endpoints for creating events, registering expenses, and calculating how much each participant owes or is owed.

Inspirated on the mobile App SplitWise.

## Features

Event Management: Create and manage events with details like date, location, and participants.
Expense Tracking: Add expenses for each event and specify who paid and how much.
Debt Calculation: Automatically calculate the amount owed by each participant based on the expenses logged.

### Prerequisites
- SpringBoot (JAVA)
- MySQL

#### Spring dependencies
- spring-boot-starter-data-jdbc
- spring-boot-starter-data-jpa
- spring-boot-starter-web
- spring-boot-starter-security
- mysql-connector-j
- spring-boot-starter-test
- java-jwt


## Installation
git clone https://github.com/Darwin231/cost-splitter.git
cd cost-splitter-api
npm install


## API Documentation

### User
- __POST__ ("/user") -> To create a new user.
- __GET__ ("/user/{userId}") -> To search for user by ID.

### Events
- __POST__ ("/event") -> To create a new event.
- __GET__ ("/event/events) -> To list all the events registered.
- __GET__ ("/event/{eventId}/assistants") -> To list all the assistants in the selected event.
- __PATH__ ("/event/assistant/{eventId}") -> To add an assistant to the event selected.

### Debt
- __POST__ ("/debt") -> Create a new debt. Remeber to mark by the event.
- __GET__ ("/debt/{eventId}/debts") -> List all the debts by event.
- __GET__ ("/debt/{userId}/debts") -> List all debts by user.
- __POST__ ("/debt/{debtId}/debtors") -> Add a new debtor to the debt.
- __GET__ ("/debt/{debtId}/amounts") -> Calculates the amounts to pay.
- __PUT__ ("/debt/payed") -> To pay a debt by user.


Feel free to customize this README by adding more specifics about your API, such as more detailed API documentation, usage examples, and any other relevant information that users of your API would need.


- Author: Darwin Diaz
- github: https://github.com/Darwin231





