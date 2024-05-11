# Cost Splitter API

## Overview

__Cost Splitter__ is a *RESTful API* designed to manage events and associated debts, enabling users to effortlessly split bills among participants. This API provides endpoints for creating events, registering expenses, and calculating how much each participant owes or is owed.

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

### Events
__/POST/__ ("/event") -> to create a new event



