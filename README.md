# CSI 2132 Assignment

An eHotel booking system created over the course of the term project.

## Description

You are requested to do the following:
1. (15%) Create the ER model that corresponds to the above description.
2. (10%) Create the Relational model that corresponds to your ER model.
3. (10%) Define the necessary constraints that will ensure the correctness of the database to be
created according to your Relational model. These are primary keys, referencial integrity
constraints, domain constraints and user-defined constraints.
4. (10%) Implement the database according to your Relational model and the constraints that
you have defined.
5. (10%) Create the necessary SQL modifications (use queries and triggers): Your database
should allow insert, delete and update operations of data in your database according to the
referential integrity constraints that you have defined. Give the SQL code for at least 4 queries
and 2 triggers in your report.
6. (5%) Insert in your database data for each one of the 5 hotel chains. Each one of them has at
least 8 hotels, which belong to at least 3 categories. Two of the hotels at least should be in the
same area. Each hotel should have at least 5 rooms of different capacity.
7. (30%) Design and implement an appropriate User Interface, through which a user will be able
to see the available rooms by giving different, multiple and combinations of criteria in order
to chooce the room that he/she is interested in and book it or rent it. These criteria should be:
the dates (start, end) of booking or renting, the room capacity, the area, the hotel chain, the
category of the hotel, the total number of rooms in the hotel, the price of the rooms. The user
should be able to see the available choices when he/she changes the value of any of these
criteria. The User Interface should allow the insert/delete/update of all information related to
customers, employees, hotels and rooms. The user can be either a customer (who will use the
interface in order to search for rooms and do bookings) or a hotel employee (who will use the
interface to either turn a booking to renting when a customer checks in the hotel, or do
directly a renting when a customer presents physically to the hotel). An employee should be
able to insert a customer payment for a renting through the interface. The User Interface
should be user friendly, meaning that the user is not required to know SQL. All information
should be presented to the user through appropriately designed forms. Whenever necessary
you should use appropriate elements, like drop-down lists, radio buttons etc.
8. (10%) The user should be able to see also two specific Views. View 1: the first view is the
number of available rooms per area. View 2: the second view is the capacity of all the rooms
of a specific hotel. 
