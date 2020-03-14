# Hello Servlet - Learn Fundamental Servlet Technology

This repository is used to learn servlet technology. In this project Tomcat embedded as a servlet container is provided.
Read the `Run Program` guide to running the server.


### Run Program
- `mvn package`
- `sh target/bin/webapp` for unix base OS
- `target/bin/webapp.bat` for Windows OS

### Resource
- [Java for the Web with Servlets, JSP, and EJB: A Developer's Guide to J2EE Solutions](https://www.amazon.com/Java-Web-Servlets-JSP-EJB/dp/073571195X) 
~ Budi Kurniawan
- [Dasar-dasar Aplikasi Web Java](https://software.endy.muhardin.com/java/dasar-dasar-aplikasi-web-java/) ~ Endy Muhardin

## The Hypertext Transfer Protocol (HTTP)
HTTP is the protocol that allows web servers and browsers to exchange data over the web. It is a request
and response protocol. The client requests a file and the server responds to the request. HTTP uses reliable
TCP connections—by default on TCP port 80.

In HTTP, it's always the client who initiates a transaction by establishing a connection and sending an
HTTP request. The server is in no position to contact a client or make a callback connection to the client.

### HTTP Requests
An HTTP transaction begins with a request from the client browser and ends with a response from the
server. An HTTP request consists of three components:
- Method——URI—Protocol/Version
- Request headers
- Entity body

An example of an HTTP request is the following:
```
GET /servlet/default.jsp HTTP/1.1
Accept: text/plain; text/html
Accept-Language: en-gb
Connection: Keep-Alive
Host: localhost
Referer: http://localhost/ch8/SendDetails.htm
User-Agent: Mozilla/4.0 (compatible; MSIE 4.01; Windows 98)
Content-Length: 33
Content-Type: application/x-www-form-urlencoded
Accept-Encoding: gzip, deflate
LastName=Franks&FirstName=Michael
```

Note: HTTP 1.0 only has three request methods: GET, HEAD, and POST.

### HTTP Responses
Similar to requests, an HTTP response also consists of three parts:
- Protocol — Status code — Description
- Response headers
- Entity body

The following is an example of an HTTP response:
```
HTTP/1.1 200 OK
Server: Microsoft-IIS/4.0
Date: Mon, 3 Jan 1998 13:13:33 GMT
Content-Type: text/html
Last-Modified: Mon, 11 Jan 1998 13:23:42 GMT
Content-Length: 112

<HTML>
<HEAD>
<TITLE>HTTP Response Example</TITLE></HEAD><BODY>
Welcome to Brainy Software
</BODY>
</HTML>
```

Note: The headers and the entity body are separated by a sequence of CRLFs.


## What is servlet?
"The servlet technology is the foundation of web application development using the Java programming
language. It is one of the most important Java technologies, and it is the underlying technology for another
popular Java technology for web application development: JavaServer Pages (JSP)." -- Budi Kurniawan

A servlet is a Java class that can be loaded dynamically into and run by a special web server. This servletaware
web server is called a servlet container, which also was called a servlet engine in the early days of the
servlet technology.