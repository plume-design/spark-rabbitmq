import sbt._
import sbt.Keys._

name := "spark-rabbitmq"

parallelExecution := false
fork in test := true


// enable publishing the jar produced by `test:package`
publishArtifact in (packageBin) := true

scalacOptions ++= Seq(
  "-feature",
  "-language:experimental.macros"
)

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")


version in ThisBuild := "0.7.0-SNAPSHOT"

scalaVersion in ThisBuild := "2.11.8"

organization in ThisBuild := "com.stratio.receiver"

isSnapshot := true

libraryDependencies ++= {
  val sparkVersion = "2.4.0"
  val amqpClientVersion = "3.6.6"
  val akkaActorVersion = "2.5.3"
  val jodaVersion = "2.8.2"
  val scalaTestVersion = "3.0.1"
  val junitVersion = "4.8.1"
  val scalaCheckVersion = "1.13.3"
  val jacksonVersion = "2.6.5"
  val hadoopVersion = "2.7.3"

  // Dependencies
  Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion % "provided" ,
  "org.apache.spark" %% "spark-streaming" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-sql" % sparkVersion % "provided" ,
  "org.apache.hadoop" % "hadoop-client" % hadoopVersion % "provided" ,
  "com.typesafe.akka" %% "akka-actor" % akkaActorVersion,
  "joda-time" % "joda-time" % jodaVersion,
  "com.github.sstone" %% "amqp-client" % "1.5",
  "com.fasterxml.jackson.core" % "jackson-databind" % jacksonVersion,
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % jacksonVersion,
  "org.scalatest" %% "scalatest" % scalaTestVersion,
  "org.scalacheck" %% "scalacheck" % scalaCheckVersion,
  "junit" % "junit" % junitVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaActorVersion,
  "com.rabbitmq" % "amqp-client" % amqpClientVersion
  )

}

resolvers ++= Seq(
  "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/",
  "JBoss Repository" at "http://repository.jboss.org/nexus/content/repositories/releases/",
  "Spray Repository" at "http://repo.spray.cc/",
  "Cloudera Repository" at "https://repository.cloudera.com/artifactory/cloudera-repos/",
  "Akka Repository" at "http://repo.akka.io/releases/",
  "Twitter4J Repository" at "http://twitter4j.org/maven2/",
  "Apache HBase" at "https://repository.apache.org/content/repositories/releases",
  "Twitter Maven Repo" at "http://maven.twttr.com/",
  "scala-tools" at "https://oss.sonatype.org/content/groups/scala-tools",
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Second Typesafe repo" at "http://repo.typesafe.com/typesafe/maven-releases/",
  "Mesosphere Public Repository" at "http://downloads.mesosphere.io/maven",
  "Eclipse Paho" at "https://repo.eclipse.org/content/repositories/paho-releases",
  "Artima Maven Repository" at "http://repo.artima.com/releases",
  Resolver.sonatypeRepo("public")
)


// Publish
publishTo := Some("Plume Artifactory" at "https://artifactory-artifactory-01.inf.us-west-2.aws.plume.tech/artifactory/ivy-releases-local")


