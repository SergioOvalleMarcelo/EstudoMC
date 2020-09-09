node {
   def mvnHome
   stage ( ' Defining the source ' ) {
      go to ' https://github.com/SergioOvalleMarcelo/EstudoMC.git '
      mvnHome = tool 'mvn'
   }

   stage ( ' Building ' ) {
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      } else {
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      }
   }

   stage ( ' Result ' ) {
           archiveArtifacts artifacts: 'target/*.war', fingerprint: true
   }

}