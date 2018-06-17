<?php
require "init.php";
$message = $_POST['message'];
$title = $_POST['title'];
$path_to_from = 'https://fcm.googleapis.com/fcm/send';
$server_key = "AAAAyBECslE:APA91bGMoBHLXveTYeVeI4f4nN77fe3fCPsnilwenI5oEbc5QU-Jr4vQkrUG-r8r-KGD8oUl-n2_5_P-vE1VsIuSuefhWA3Y2JV0BG0tU_yGdrJihKZ1LrfZ8mvhSCWFkuIsXc_tYF9H";
$sql = "select fcm_token from fcm_info";
$result = mysqli_query($con,$sql);
$row = mysqli_fetch_row($result);
$key = $row[0];

$headers = array( 'Content-Type:application/json', 'Authorization:Key=' .$server_key );

$fields = array('to' =>$key,'notification'=>array('title' =>$title ,'body'=>$message));

$payload = json_encode($fields);

$curl_session = curl_init();

curl_setopt($curl_session, CURLOPT_URL, $path_to_from);
curl_setopt($curl_session, CURLOPT_POST, true);
curl_setopt($curl_session, CURLOPT_HTTPHEADER, $headers);
curl_setopt($curl_session, CURLOPT_RETURNTRANSFER, true);
curl_setopt($curl_session, CURLOPT_SSL_VERIFYPEER, false);
curl_setopt($curl_session, CURLOPT_IPRESOLVE, CURL_IPRESOLVE_V4);
curl_setopt($curl_session, CURLOPT_POSTFIELDS, $payload);
$result = curl_exec($curl_session);
curl_close($curl_session);
mysqli_close($con);
?>