# Accounting_company_administration_app

This is an app that was conceived with an accounting company owner to create tools needed for proper management and
administration of the firms resources. Main goal is to ensure that certain repeated tasks were performed for all clients
necessitating a task tracking service.

The company is currently operating using accounting software that doesn't provide the desired functionalities. Therefore, 
the necessity for a supporting app that will provide the desired tools and data aggregation. Data from the existing SQL 
database used by the accounting software will be utilized by this app as well. Additional database will be added to hold
data specific to the app and its functionalities. Since the accounting software is using MSSql database, the app will 
use the same technology for consistency.

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
   d) Reminders:
        - VAT returns,
        - Leasing,
        - Amortization,
        - Interperiodical settlements (accruals - rozliczenia międzyokresowe).
3. A tool to track work is needed. A request was made for window with a start/stop button that would track how long 
performing a task took.
4. A tool tracking a list of additional tasks to be performed for a client was requested.
5. Ability to read from database data for documents such as contracts.

Some of the above ideas could be implemented by creating work templates containing checklists of periodically performed 
tasks. Perhaps a list of smaller checklists would serve best (bread or specific). The time tracking tool could be paired
with the checklist tracking progress of work along with time spent performing tasks. This could then be saved to database
to build foundation for data analysis.

Technology stack:
1. Java 14 with Maven and Spring framework - main logic and server side
2. REST API - BE-FE communication
3. React - FE
4. JMS - microservices communication.
5. RPC (GRPC) - calling methods between libraries.
6. MSSQL - DB