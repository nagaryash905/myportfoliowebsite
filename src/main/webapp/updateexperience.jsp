<%@page import="com.portfolio.model.ExperiencePojo"%>
<%@ include file="security.jsp" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Upadate Experience</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-container {
            width: 70%;
            padding: 20px;
            background-color: #DCC9C5;/* Red background color */
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #333;
        }

        form {
            margin-top: 20px;
        }

        table {
            width: 100%;
        }

        table tr td {
            padding: 8px 0;
        }

        input[type="text"],
        textarea {
            width: calc(100% - 10px);
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        textarea {
            height: 150px; /* Increased height for description field */
        }

        button[type="submit"] {
            width: 100%;
            padding: 10px 0;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>

<body>

    <div class="form-container">

        <h2>Update Experience</h2>

        <%
            int index = Integer.parseInt(request.getParameter("index"));
            ArrayList<ExperiencePojo> al = (ArrayList<ExperiencePojo>) session.getAttribute("readexperience");
            if (al != null && !al.isEmpty()) {
            	ExperiencePojo ep = al.get(index);
        %>

        <form action="UpdateExperienceServlet" method="post">
            <table>
           	  <tr style="display: none;">
                    <td>SN :</td>
                    <td><input type="text" id="sn" name="sn" value="<%=ep.getSn()%>"></td>
                </tr>
                <tr>
                    <td>Year :</td>
                    <td><input type="text" id="year" name="year" value="<%=ep.getYear()%>"></td>
                </tr>
                <tr>
                    <td>Job Title :</td>
                    <td><input type="text" id="title" name="jobtitle" value="<%=ep.getJobtitle()%>"></td>
                </tr>
                <tr>
                    <td>Company :</td>
                    <td><input type="text" id="company" name="company" value="<%=ep.getCompany()%>"></td>
                </tr>
                <tr>
                    <td>Description :</td>
                    <td><textarea id="description" name="description"><%=ep.getDescription()%></textarea></td>
                </tr>
                <tr>
                    <td colspan="2"><button type="submit">Update Experience</button></td>
                </tr>
            </table>
        </form>

        <% } %>

    </div>

</body>

</html>
