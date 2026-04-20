CREATE DATABASE RestaurantDB;
USE RestaurantDB;

CREATE TABLE Restaurant (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100),
    Address VARCHAR(255)
);

CREATE TABLE MenuItem (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100),
    Price DOUBLE,
    ResId INT,
    FOREIGN KEY (ResId) REFERENCES Restaurant(Id)
);
INSERT INTO Restaurant (Name, Address) VALUES
('Cafe Java', 'Pune'),
('Food Hub', 'Mumbai'),
('Spice Villa', 'Delhi'),
('Tasty Bites', 'Bangalore'),
('Green Leaf', 'Chennai'),
('Urban Kitchen', 'Hyderabad'),
('Royal Dine', 'Jaipur'),
('Quick Eat', 'Ahmedabad'),
('Food Court', 'Kolkata'),
('Street Feast', 'Surat');

INSERT INTO MenuItem (Name, Price, ResId) VALUES
('Pasta', 80, 1),
('Pizza', 120, 1),
('Burger', 90, 2),
('Pav Bhaji', 70, 3),
('Paneer Tikka', 150, 4),
('Paratha', 60, 5),
('Pulao', 95, 6),
('Noodles', 110, 7),
('Pizza Small', 85, 1),
('Pancake', 50, 8);