<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 800px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        .profile {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .profile img {
            border-radius: 50%;
            width: 150px;
            height: 150px;
            object-fit: cover;
        }
        .profile h2 {
            margin-top: 10px;
            color: #555;
        }
        .profile-details {
            margin-top: 20px;
            width: 100%;
        }
        .profile-details table {
            width: 100%;
            border-collapse: collapse;
        }
        .profile-details table th, .profile-details table td {
            text-align: left;
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }
        .profile-details table th {
            background-color: #f9f9f9;
        }
        .edit-profile {
            text-align: center;
            margin-top: 20px;
        }
        .edit-profile a {
            text-decoration: none;
            background-color: #28a745;
            color: #fff;
            padding: 10px 20px;
            border-radius: 5px;
            font-weight: bold;
        }
        .edit-profile a:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Your Profile</h1>

    <div class="profile-details">
        <table>
              <img src="${avatar}" alt="User Avatar" />  
            <tr>
                <th>Name: ${username}</th>      
            </tr>
            <tr>
                <th>Phone: ${phone}</th>      
            </tr>
        </table>
    </div>
    </div>
</div>

</body>
</html>
