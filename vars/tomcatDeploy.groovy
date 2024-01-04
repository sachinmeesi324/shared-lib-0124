def call(ipAddress,userName,credentialId,warName){
  sshagent([credentialId]) {
                sh "scp -o StrictHostKeyChecking=no target/${warName} ${userName}@${ipAddress}:/opt/tomcat9/webapps/"
                sh "ssh ${userName}@${ipAddress} /opt/tomcat9/bin/shutdown.sh"
                sh "ssh ${userName}@${ipAddress} /opt/tomcat9/bin/startup.sh"
}
}
