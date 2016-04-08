
    create table additionalfields (
        fieldId int4 not null,
        fieldtype varchar(255),
        name varchar(255),
        required boolean not null,
        dept_deptId int4,
        primary key (fieldId)
    );

    create table applicantadditonalfieldvalues (
        fieldValueId int4 not null,
        value varchar(255),
        applicant_id int4,
        additionalfield_id int4,
        primary key (fieldValueId)
    );

    create table applications (
        applicationId int4 not null,
        cin varchar(255),
        citizenship varchar(255),
        comment varchar(255),
        dob varchar(255),
        emailid varchar(255),
        firstname varchar(255),
        gender varchar(255),
        gpa float8,
        grescore int4,
        international boolean not null,
        lastname varchar(255),
        modifiedtime timestamp,
        phoneNumber varchar(255),
        toeflscore int4,
        transcript varchar(255),
        dept_deptId int4,
        program_programId int4,
        status_statusId int4,
        term_termId int4,
        user_userId int4,
        primary key (applicationId)
    );

    create table applicationstatusaudit (
        statusauditId int4 not null,
        comment varchar(255),
        modifiedtime timestamp,
        applicantId int4,
        modifiedBy int4,
        newstatus_statusId int4,
        oldstatus_statusId int4,
        primary key (statusauditId)
    );

    create table departments (
        deptId int4 not null,
        department varchar(255),
        grerequired boolean not null,
        primary key (deptId)
    );

    create table educationalbackgrounds (
        eduId int4 not null,
        college varchar(255),
        degree varchar(255),
        duration int4,
        major varchar(255),
        applicant_applicationId int4,
        primary key (eduId)
    );

    create table programs (
        programId int4 not null,
        program varchar(255),
        dept_deptId int4,
        primary key (programId)
    );

    create table statuses (
        statusId int4 not null,
        value varchar(255),
        primary key (statusId)
    );

    create table terms (
        termId int4 not null,
        termname varchar(255),
        primary key (termId)
    );

    create table users (
        userId int4 not null,
        email_id varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        primary key (userId)
    );

    create table users_userstype (
        lstUsers_userId int4 not null,
        lstusertype_userstypeId int4 not null
    );

    create table userstype (
        userstypeId int4 not null,
        type varchar(255),
        primary key (userstypeId)
    );

    alter table additionalfields 
        add constraint FK_pn7sk076jpbbxdnjp15kc0scx 
        foreign key (dept_deptId) 
        references departments;

    alter table applicantadditonalfieldvalues 
        add constraint FK_rwvcn46tkcyq5uh5i6tb3qtb1 
        foreign key (applicant_id) 
        references applications;

    alter table applicantadditonalfieldvalues 
        add constraint FK_2xc89q6e1m8uv8gsynv8cqgef 
        foreign key (additionalfield_id) 
        references additionalfields;

    alter table applications 
        add constraint FK_5pf8cs1jc96bqqev9fglwoi2t 
        foreign key (dept_deptId) 
        references departments;

    alter table applications 
        add constraint FK_8wu9pqsp7509bukuttqm6ii5p 
        foreign key (program_programId) 
        references programs;

    alter table applications 
        add constraint FK_m4tb59c1ittrlp79yskni55ul 
        foreign key (status_statusId) 
        references statuses;

    alter table applications 
        add constraint FK_h6etnygfi0ki017707xbowxo6 
        foreign key (term_termId) 
        references terms;

    alter table applications 
        add constraint FK_k1lok6tvd463v97b6d4nd5cpu 
        foreign key (user_userId) 
        references users;

    alter table applicationstatusaudit 
        add constraint FK_gt5h4r86n5686c7ibvf18ooje 
        foreign key (applicantId) 
        references applications;

    alter table applicationstatusaudit 
        add constraint FK_dc04llvteje4t2s1h9dsnol73 
        foreign key (modifiedBy) 
        references users;

    alter table applicationstatusaudit 
        add constraint FK_c4m2ygexynu1r9mqxxbm8ud7f 
        foreign key (newstatus_statusId) 
        references statuses;

    alter table applicationstatusaudit 
        add constraint FK_o4er97wgurnmq19v1h5i9hh65 
        foreign key (oldstatus_statusId) 
        references statuses;

    alter table educationalbackgrounds 
        add constraint FK_5e182xctpko5bfqlwxsnwk7ey 
        foreign key (applicant_applicationId) 
        references applications;

    alter table programs 
        add constraint FK_nukuqs5hc9dxrp4b4f9mvn4yt 
        foreign key (dept_deptId) 
        references departments;

    alter table users_userstype 
        add constraint FK_6hi19x3veuqyyw2xwrphogeat 
        foreign key (lstusertype_userstypeId) 
        references userstype;

    alter table users_userstype 
        add constraint FK_398epqhtqaj6abfnwqsy59e7h 
        foreign key (lstUsers_userId) 
        references users;

    create sequence hibernate_sequence;
