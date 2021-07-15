# shaka-elegibleoffers-mo

Ofertas Elegibles Moviles


Codigo para generar swagger y wsdl de AMDOCS :

			<!-- TO GENERATE WSDL CLASSES -->
			<plugin>
				<groupId>org.apache.cxf</groupId>
				<artifactId>cxf-codegen-plugin</artifactId>
				<version>3.1.15</version>
				<executions>
					<execution>
						<id>generate-sources</id>
						<phase>generate-sources</phase>
						<configuration>
							<sourceRoot>${basedir}/target/generated/</sourceRoot>
							<wsdlOptions>
								<wsdlOption>
									<wsdl>${basedir}/src/main/resources/wsdl/amdocs_penalty.wsdl
									</wsdl>
								</wsdlOption>
							</wsdlOptions>
						</configuration>
						<goals>
							<goal>wsdl2java</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
			<plugin>
				<groupId>io.swagger</groupId>
				<artifactId>swagger-codegen-maven-plugin</artifactId>
				<version>2.2.2</version>
				<executions>
					<execution>
						<id>execution-ProductCatalogManagement</id>
						<goals>
							<goal>generate</goal>
						</goals>
						<configuration>
							<inputSpec>${project.basedir}/src/main/resources/static/Product
								Catalog Management_v3.3.0_swagger.yaml</inputSpec>
							<language>spring</language>
							<generateSupportingFiles>false</generateSupportingFiles>
							<configOptions>
								<java8>true</java8>
								<library>spring-mvc</library>
								<apiPackage>com.telefonica.eof.generated.api</apiPackage>
								<modelPackage>com.telefonica.eof.generated.model</modelPackage>
								<serializableModel>true</serializableModel>
								<interfaceOnly>true</interfaceOnly>
							</configOptions>
						</configuration>
					</execution>
				</executions>
			</plugin>
<<<<<<< HEAD
=======
<<<<<<< HEAD

			<!-- TO GENERATE WSDL CLASSES -->
<!-- 			<plugin>
				<groupId>org.apache.cxf</groupId>
				<artifactId>cxf-codegen-plugin</artifactId>
				<version>3.1.15</version>
				<executions>
					<execution>
						<id>generate-sources</id>
						<phase>generate-sources</phase>
						<configuration>
							<sourceRoot>${basedir}/src/main/java/</sourceRoot>
							<wsdlOptions>
								<wsdlOption>
									<wsdl>${project.basedir}/src/main/resources/wsdl/ro/v1.wsdl
									</wsdl>
								</wsdlOption>
								<wsdlOption>
									<wsdl>${project.basedir}/src/main/resources/wsdl/cp/v1.wsdl
									</wsdl>
								</wsdlOption>
							</wsdlOptions>
						</configuration>
						<goals>
							<goal>wsdl2java</goal>
						</goals>
					</execution>
				</executions>
			</plugin> -->
			<!-- TO GENERATE WSDL CLASSES -->
=======
>>>>>>> ff2a5c960029ee1d3e9ea0943f246533283f0c31
>>>>>>> 6c0de7adde10beca42fef4624b34166ff80b5951
			
		<pluginManagement>
			<plugins>
				<plugin>
					<groupId>org.eclipse.m2e</groupId>
					<artifactId>lifecycle-mapping</artifactId>
					<version>1.0.0</version>
					<configuration>
						<lifecycleMappingMetadata>
							<pluginExecutions>
								<pluginExecution>
									<pluginExecutionFilter>
										<groupId>io.swagger</groupId>
										<artifactId> swagger-codegen-maven-plugin </artifactId>
										<versionRange> [2.2.2,) </versionRange>
										<goals>
											<goal>generate</goal>
										</goals>
									</pluginExecutionFilter>
									<action>
										<ignore></ignore>
									</action>
								</pluginExecution>
							</pluginExecutions>
						</lifecycleMappingMetadata>
					</configuration>
				</plugin>
			</plugins>
		</pluginManagement>