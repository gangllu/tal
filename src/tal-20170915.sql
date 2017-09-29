ALTER TABLE `tal`.`bbs_reply` 
ADD COLUMN `image_path` VARCHAR(500) NULL AFTER `correct`;

ALTER TABLE `tal`.`knowledge` 
ADD COLUMN `answer_title` VARCHAR(450) NULL AFTER `user_id`,
ADD COLUMN `answer_content` LONGTEXT NULL AFTER `answer_title`,
ADD COLUMN `answer_file` VARCHAR(4000) NULL AFTER `answer_content`;
