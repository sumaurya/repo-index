CREATE TABLE `repository` (
  `repository_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `url` varchar(500) not null,
  PRIMARY KEY (`repository_id`),
  unique(url)
);

CREATE TABLE `project` (
  `project_id` int(11) NOT NULL AUTO_INCREMENT,
  `repository_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  FOREIGN KEY (repository_id) REFERENCES repository(repository_id)
);


CREATE TABLE `version` (
  `version_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `version` varchar(32) NOT NULL,
  `liscence` varchar(100) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `depends_on` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`version_id`),
  unique(url),
  CONSTRAINT `version_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`)
);

CREATE TABLE `author` (
  `author_id` int(11) NOT NULL AUTO_INCREMENT,
  `version_id` int(11) NOT NULL,
  `name` varchar(500) DEFAULT NULL,
  `email` varchar(2000) NOT NULL,
  PRIMARY KEY (`author_id`),
  FOREIGN KEY (`version_id`) REFERENCES `version` (`version_id`)
);