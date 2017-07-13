### File Uploading using StandardServletMultipartResolver, configured with WebApplicationInitializer

#### Significant configuration files:

- spittr.config.SpittrWebAppInitializer
- spittr.config.WebConfig

#### Other significant files

- /main/webapp/WEB-INF/views/registerForm.jsp
  - form enctype attribute
  - file input
- spittr.web.FileUploadController

This project only works on Servlet 3.0 supported servers and Spring 3.1+ like tomcat7 as StandardServletMultipartResolver is only supported since Servlet 3.0 and since Spring 3.1