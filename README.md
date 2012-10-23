sandbox
=======

learning and having fun

Ti enable remote debugging add to startup.sh:
export JPDA_ADDRESS=8000
export JPDA_TRANSPORT=dt_socket
export JPDA_HOST=localhost
 and at the bottom of the file:
 exec "$PRGDIR"/"$EXECUTABLE" jpda start "$@"
 

follow instructions in here:
https://confluence.sakaiproject.org/display/BOOT/Debugging+Tomcat+Remotely+Using+Eclipse
