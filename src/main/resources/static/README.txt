Pasos para generar clases desde swagger.yaml

1.- Dejar el file.yaml en la ruta src/main/resources/static
2.- Eliminar el paquete com.telefonica.eom.generated.offers.model para que no haga conflicto al generar las clases
3.- Agregar al pom:

	<build>
		<plugins>
		
			<!-- plugin -->
			<!-- ... -->
			<!-- plugin -->

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
							<inputSpec>${project.basedir}/src/main/resources/static/${swagger-template.name}</inputSpec>
							<language>spring</language>
							<generateSupportingFiles>false</generateSupportingFiles>
							<configOptions>
								<java8>true</java8>
								<library>spring-mvc</library>
								<apiPackage>com.telefonica.eom.generated.offers.api</apiPackage>
								<modelPackage>com.telefonica.eom.generated.offers.model</modelPackage>
								<serializableModel>true</serializableModel>
								<interfaceOnly>true</interfaceOnly>
							</configOptions>
						</configuration>
					</execution>
					<execution>
						<id>execution-ProductInventory</id>
						<goals>
							<goal>generate</goal>
						</goals>
						<configuration>
							<inputSpec>${project.basedir}/src/main/resources/static/Product_Inventory_v3.2.0.yml</inputSpec>
							<language>spring</language>
							<generateSupportingFiles>false</generateSupportingFiles>
							<configOptions>
								<java8>true</java8>
								<library>spring-mvc</library>
								<apiPackage>com.telefonica.eom.generated.pinventory.api</apiPackage>
								<modelPackage>com.telefonica.eom.generated.pinventory.model</modelPackage>
								<serializableModel>true</serializableModel>
								<interfaceOnly>true</interfaceOnly>
							</configOptions>
						</configuration>
					</execution>
				</executions>
			</plugin>

		</plugins>

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
										<artifactId>
											swagger-codegen-maven-plugin
										</artifactId>
										<versionRange>
											[2.2.2,)
										</versionRange>
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

	</build>
	
4.- Ejecutar mvn install
5.- Ejecutar mvn clean compile (se generarán las clases en la ruta especificada)
6.- copiar el contenido de target.generated-sources.swagger.src.main.java.com.telefonica.eom.generated.offers.model a la carpeta raíz
7.- Borrar el contenido agregado en el paso 3 del pom
8.- Ejecutar mvn clean
