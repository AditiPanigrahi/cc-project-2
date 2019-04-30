# cc-project-2
1) create cloud sql instance
2) create database in cloud sql instance from console 
3) change spring.jpa.hibernate.ddl-auto=create-drop from update to create the tables when app runs
4) change properties accordingly

spring.cloud.gcp.projectId=${project Id}
spring.cloud.gcp.sql.databaseName=${db name} 
spring.cloud.gcp.sql.instance-connection-name=${project Id}:${zone}:${instance name}(avaialble in overview on cloud sql page)
spring.datasource.password=${password} // required
spring.datasource.username=${username} // default is root, no need to specify then
