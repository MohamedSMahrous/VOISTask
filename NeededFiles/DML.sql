INSERT INTO `status`(`id`, `status_name`) VALUES (1,'Waiting_For_Activation');
INSERT INTO `status`(`id`, `status_name`) VALUES (2,'Active');
INSERT INTO `status`(`id`, `status_name`) VALUES (3,'Blocked');
INSERT INTO `status`(`id`, `status_name`) VALUES (4,'Deactivated');



INSERT INTO `operator`(`id`, `operator_id`, `operator_name`) VALUES (1,1,'Vodafone');
INSERT INTO `operator`(`id`, `operator_id`, `operator_name`) VALUES (2,2,'Etisalat');
INSERT INTO `operator`(`id`, `operator_id`, `operator_name`) VALUES (3,3,'WE');


INSERT INTO `device`(`id`, `country`, `sim_id`, `operator_id`, `status_id`) 
VALUES (1,'Egypt','123456789',1,1);

INSERT INTO `device`(`id`, `country`, `sim_id`, `operator_id`, `status_id`) 
VALUES (2,'France','123456790',2,1);

INSERT INTO `device`(`id`, `country`, `sim_id`, `operator_id`, `status_id`) 
VALUES (3,'Germany','123456791',2,2);

INSERT INTO `device`(`id`, `country`, `sim_id`, `operator_id`, `status_id`) 
VALUES (4,'England','123456792',2,2);

INSERT INTO `device`(`id`, `country`, `sim_id`, `operator_id`, `status_id`) 
VALUES (5,'Russia','123456793',3,4);
