Program Challenges:

1. Given the list of hotels and list of keywords and multiple reviews for multiple hotels, sort hotels by number of keywords in their combined reviews
   https://fizzbuzzer.com/sort-hotel-list-challenge/
   
2. Given a number of customer service employees and a list of timestamps of start and end of a phone calls tell how many more customer service employees are necessary so every phone call could be answered  
   
1. SSH into a server. A process is running and is printing a message somewhere. Find out what the message is.

  * Solution 1: Linux will provide a list of open file descriptors in the procfs. tail it like so: tail -f /proc/PID/fd/1 
  * Solution 2: strace -p PID
  
2. A developer claims that his script is not being able to connect to auth web server in (one weblink) , but it works on a different server.You need to find out what could be happening and fix that.

   iptables-save can find out all the iptable rules.
   https://www.zsythink.net/archives/1199
   https://www.centos.bz/2017/08/iptables-rules-add-delete-modify-save/
   create a iptables rule to drop incoming traffic to port 4000
   `sudo iptables -A INPUT  -p tcp --dport 4000 -j DROP`
   delete the iptables rule we created 
   `sudo iptables -D INPUT  -p tcp --dport 4000 -j DROP`
   
3. We just got informed that web server has been hacked !! The  index page is showing a "pwned" message that we should revert Our monitoring checks report the message "Failed connect to localhost:80, Connection refused" But we have backup server of index file at path "some path" that you should restore to server's DocumentRoot file.

  Move the folder www to www2, create a new folder www and put the new index there.
edit the apache config file to setup the proper port.

  * Useful commands:
  	* sudo systemctl status apache2
  	* sudo systemctl stop apache2
  	* sudo systemctl start apache2
  * Configs
    * /etc/apache2/

4. SSH into a server. Enable Google DNS as a secondary DNS server
   
   add 'nameserver 8.8.8.8' to resolv.conf
   

