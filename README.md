# Accounting_company_administration_app

This app was initially conceived with an accounting company owner to create tools needed for proper management and
administration of the firms resources. While the requirements haven't changed much since then, the general idea of how
the app should look like from a technological point of view has drastically evolved. This is mostly due to gaining much 
more professional experience, internalizing knowledge gained in a software architecture training and generally becoming
better informed and acting with more awareness. Therefore, while I've elected to keep the original summary (at least for
now) it should be mostly used as a reference on how the concept was approached initially and how it evolved.

At the start the app was supposed to be built using microservices. However, until the project reaches at least MVP level
it seems to be best to develop it using the modular monolith concept. Most functionalities will be added in designated 
packages and will be considered for separation later on. The goal is to begin development with clear boundaries between
modules to make it as easy as possible to turn them into microservices if such need arises. 

## Legacy summary:

This app idea was conceived with an accounting company owner to create tools needed for proper management and
administration of the firms resources. Main goal is to ensure that certain repeated tasks were performed for all clients
necessitating a task tracking service.

The company is currently operating using accounting software that doesn't provide the desired functionalities. Therefore, 
the necessity for a supporting app that will provide the needed tools and data aggregation. Data from the existing SQL 
database used by the accounting software will be utilized by this app as well. Additional database will be added to hold
data specific to the app and its functionalities. Since the accounting software is using MSSql database, the app will 
use the same technology for consistency if possible. If not PostGreSql will be used which will necessitate migrating data
from one db to the other in prod.

Main goal of this project is to refine existing skill and learn new technologies while creating an MVP to use as a
foundation for an ongoing development and sophistication of the app. One of the aims is to divide the app into multiple
microservices to get a better grasp on their architecture and required supporting technologies. One of the learning goals
also coincides with using messaging and queueing tools. JMS and RPC (GRPC) being the two first ones taken into consideration.
Building a functioning front end using the React framework is another goal furthered by building a functional REST API.

Agreed upon initial plan:
1. Data will come from the Optima database (MSSql).
2. There needs to exist a list of clients containing information:
   a) Documents:
        - delivered (boolean),
        - delivery date,
        - completed (boolean).
   b) Accounting work:
        - who does it,
        - who checks it.
   c) Taxes:
        - how much,
        - was info sent out (boolean).
   d) Possible reminder examples:
        - VAT returns,
        - Leasing,
        - Amortization,
        - Interperiodical settlements (accruals - rozliczenia międzyokresowe).
3. A tool to track work is needed. A request was made for window with a start/stop button that would track how long 
performing a task took.
4. A tool tracking a list of additional tasks to be performed for a client was requested.
5. Ability to read from database data for documents such as contracts.

Some of the above ideas could be implemented by creating work templates containing checklists of periodically performed 
tasks. Perhaps a list of smaller checklists would serve best (broad or specific). The time tracking tool could be paired
with the checklist tracking progress of work along with time spent performing tasks. This could then be saved to database
to build foundation for data analysis.

Technology stack:
1. Java 14 with Maven and Spring framework (with Spring boot generated via spring initializer) - main logic and server side.
2. REST API - BE-FE communication.
3. JS/React - FE.
4. JMS - microservices communication.
5. RPC (GRPC) - calling methods between libraries.
6. MSSQL (PSQL) - DB.