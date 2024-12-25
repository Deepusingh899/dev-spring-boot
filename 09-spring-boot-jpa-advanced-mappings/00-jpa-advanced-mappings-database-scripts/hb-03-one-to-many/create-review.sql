use `hb-03-one-to-many`;

CREATE TABLE `review` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`commet` varchar(256) DEFAULT NULL,
`course_id` int(11) DEFAULT NULL
)