CREATE TABLE `all_mails` (                           
             `mail_unique_id` int(11) NOT NULL auto_increment,  
             `from_mail` varchar(100) NOT NULL default '',      
             `to_mail` varchar(100) default NULL,               
             `message` varchar(1000) default NULL,              
             `mailed_date_time` varchar(100) default NULL,      
             `subject` varchar(1000) default NULL,              
             `file_name` varchar(1000) default NULL,            
             `file_src` varchar(100) default NULL,              
             UNIQUE KEY `mail_unique_id` (`mail_unique_id`)     
           ) ENGINE=InnoDB DEFAULT CHARSET=latin1               

           
           
           CREATE TABLE `login` (                  
          `username` varchar(20) default NULL,  
          `password` varchar(20) default NULL   
        ) ENGINE=InnoDB DEFAULT CHARSET=latin1  

        
        
         CREATE TABLE `gmail_users` (                      
               `username` varchar(20) NOT NULL,                
               `password` varchar(20) default NULL,            
               `first_name` varchar(20) default NULL,          
               `last_name` varchar(20) default NULL,           
               `user_status` varchar(20) default NULL,         
               `created_date_time` varchar(20) default NULL,   
               `modified_date_time` varchar(20) default NULL,  
               PRIMARY KEY  (`username`)                       
             ) ENGINE=InnoDB DEFAULT CHARSET=latin1            
