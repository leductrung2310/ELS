Insert into listening values('2e439328-d1c7-11ec-9d64-0242ac120002','The pictures have people',10,'https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_1.mp3?alt=media&token=5bc5192a-7efe-4682-88f3-adceb8a77643','Students should focus on describing the characteristics of the character''s appearance and movements based on the "be + Ving" structure.')
Insert INTO listeningquestion values('4608edc8-d1c7-11ec-9d64-0242ac120002','2e439328-d1c7-11ec-9d64-0242ac120002','The woman is _____ the street with a broom.','cleaning')
Insert INTO listeningquestion values('4608ebb6-d1c7-11ec-9d64-0242ac120002','2e439328-d1c7-11ec-9d64-0242ac120002','The woman is _____ the girl''s arm','examining')
CREATE TABLE listeningquestion (
	id TEXT PRIMARY KEY,
	listeningid TEXT,
	content TEXT,
	answer TEXT
);

CREATE TABLE listening (
	id TEXT PRIMARY KEY,
	title TEXT,
	content TEXT,
	duration INT,
	audio TEXT,
	image TEXT
);


create table readinglesson (
	id TEXT PRIMARY KEY,
	title TEXT,
	duration INT,
);

create table readingquestion(
	id TEXT PRIMARY KEY,
	readinglessonid TEXT,
	content TEXT
);

create table readinganswer(
	id TEXT PRIMARY KEY,
	readingquestionid TEXT,
	answer TEXT,
	isCorrect boolean
);

create table ELSUser (
	id TEXT PRIMARY KEY,
	name TEXT,
);

create table listeningfirebase(
	id TEXT PRIMARY KEY,
	score TEXT,
	answer TEXT,
);

create table readingfirebase(
	id TEXT PRIMARY KEY,
	score TEXT,
	answer TEXT,
);

INSERT INTO listening VALUES('2e439328-d1c7-11ec-9d64-0242ac120002','The question have one people in a picture','It should be noted that people are the focus. Listen to the description of the dideemer''s characteristics in terms of appearance, character''s movements based on the structure be - Ving','10','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_1.mp3?alt=media&token=5bc5192a-7efe-4682-88f3-adceb8a77643','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_1_image.jpg?alt=media&token=3925ba3c-2f50-459b-b906-d01ad74507e3');
INSERT INTO listening VALUES('2e439594-d1c7-11ec-9d64-0242ac120002','The question have many people in a picture','Observe people''s characteristics. Observe people''s different points of view. Locate people and things around people','10','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_1.mp3?alt=media&token=5bc5192a-7efe-4682-88f3-adceb8a77644','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_1_image.jpg?alt=media&token=3925ba3c-2f50-459b-b906-d01ad74507e4');
INSERT INTO listening VALUES('2e4396d4-d1c7-11ec-9d64-0242ac120002','The question have object','Guess the structure of the passive voice. Identify similarities and differences between things. Identify positional relationships between objects.','10','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_1.mp3?alt=media&token=5bc5192a-7efe-4682-88f3-adceb8a77645','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_1_image.jpg?alt=media&token=3925ba3c-2f50-459b-b906-d01ad74507e5');
INSERT INTO listening VALUES('2e4397ce-d1c7-11ec-9d64-0242ac120002','The question have natural landspace','Guess vocabulary about nature or interesting things. Identify relationships between things. Predetermine frequently question phrases.','10','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_1.mp3?alt=media&token=5bc5192a-7efe-4682-88f3-adceb8a77646','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_1_image.jpg?alt=media&token=3925ba3c-2f50-459b-b906-d01ad74507e6');
INSERT INTO listening VALUES('2e439c6a-d1c7-11ec-9d64-0242ac120002','Who/Where question','Who is a question about who remains, a specific title. Where is a question about a place, a particular place.','10','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_1.mp3?alt=media&token=5bc5192a-7efe-4682-88f3-adceb8a77647','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_1_image.jpg?alt=media&token=3925ba3c-2f50-459b-b906-d01ad74507e7');
INSERT INTO listening VALUES('2e439d5a-d1c7-11ec-9d64-0242ac120002','When/Which question','When is a question about a time in the past or future. Which is a choice question.','10','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_1.mp3?alt=media&token=5bc5192a-7efe-4682-88f3-adceb8a77648','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_1_image.jpg?alt=media&token=3925ba3c-2f50-459b-b906-d01ad74507e8');
INSERT INTO listening VALUES('2e439e4a-d1c7-11ec-9d64-0242ac120002','Why/How/What question','Why is a question about a reason, specifically stating a reason or making a suggestion. How is a question of manner, of quantity, of distance. What is a question about what, what time asks about time,...','10','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_1.mp3?alt=media&token=5bc5192a-7efe-4682-88f3-adceb8a77649','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_1_image.jpg?alt=media&token=3925ba3c-2f50-459b-b906-d01ad74507e9');
INSERT INTO listening VALUES('2e439f3a-d1c7-11ec-9d64-0242ac120002','Yes/No question','Yes/No is a question about have done something or want to verify something.','10','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_1.mp3?alt=media&token=5bc5192a-7efe-4682-88f3-adceb8a77650','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_1_image.jpg?alt=media&token=3925ba3c-2f50-459b-b906-d01ad74507e10');
INSERT INTO listening VALUES('2e43a02a-d1c7-11ec-9d64-0242ac120002','Selection question','Selection question is a question about choice but cannot be answered with Yes/No but must answer with specific answers.','10','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_1.mp3?alt=media&token=5bc5192a-7efe-4682-88f3-adceb8a77651','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_1_image.jpg?alt=media&token=3925ba3c-2f50-459b-b906-d01ad74507e11');
INSERT INTO listening VALUES('2e43a106-d1c7-11ec-9d64-0242ac120002','Company conservation','Listen to the main content and need to reason about the problem first. When there are structures like could you? Please pay attention to the content that appears immediately after.','10','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_1.mp3?alt=media&token=5bc5192a-7efe-4682-88f3-adceb8a77652','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_1_image.jpg?alt=media&token=3925ba3c-2f50-459b-b906-d01ad74507e12');

INSERT INTO listeningquestion VALUES('09c7d17e-dc0a-11ec-9d64-0242ac120002','2e439328-d1c7-11ec-9d64-0242ac120002','The woman is ___ the street with a broom.','cleaning');
INSERT INTO listeningquestion VALUES('09c7d3a4-dc0a-11ec-9d64-0242ac120002','2e439328-d1c7-11ec-9d64-0242ac120002','The woman is ___  the girl''s arm.','examining');
INSERT INTO listeningquestion VALUES('09c7d570-dc0a-11ec-9d64-0242ac120002','2e439328-d1c7-11ec-9d64-0242ac120002','He is ___ a phone conservation at the desk.','conducting');
INSERT INTO listeningquestion VALUES('09c7d688-dc0a-11ec-9d64-0242ac120002','2e439328-d1c7-11ec-9d64-0242ac120002','The speaker is ___ into the microphone.','speaking');
INSERT INTO listeningquestion VALUES('09c7d7a0-dc0a-11ec-9d64-0242ac120002','2e439328-d1c7-11ec-9d64-0242ac120002','He is ___ on the paper with a pen.','writing');
INSERT INTO listeningquestion VALUES('09c7d8ae-dc0a-11ec-9d64-0242ac120002','2e439328-d1c7-11ec-9d64-0242ac120002','She is ___ the liquid into the cup.','pouring');
INSERT INTO listeningquestion VALUES('09c7d9b2-dc0a-11ec-9d64-0242ac120002','2e439328-d1c7-11ec-9d64-0242ac120002','The man is ___ at the computer.','working');
INSERT INTO listeningquestion VALUES('09c7dc3c-dc0a-11ec-9d64-0242ac120002','2e439328-d1c7-11ec-9d64-0242ac120002','A woman is ___ something under her arm.','carrying');

INSERT INTO listening VALUES('2e439328-d1c7-11ec-9d64-0242ac120002','The question have one people in a picture','It should be noted that people are the focus. Listen to the description of the dideemer''s characteristics in terms of appearance, character''s movements based on the structure be - Ving','46','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_1.mp3?alt=media&token=5bc5192a-7efe-4682-88f3-adceb8a77643','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_1_image.jpg?alt=media&token=3925ba3c-2f50-459b-b906-d01ad74507e3');
INSERT INTO listening VALUES('2e439594-d1c7-11ec-9d64-0242ac120002','The question have many people in a picture','Observe people''s characteristics. Observe people''s different points of view Locate people and things around people','36','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_2.mp3?alt=media&token=a87d2e2d-baa3-44e6-aa95-1d1df47a25f1','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_2.jpg?alt=media&token=80eada87-0506-4e19-9ba3-92e65bd53c07');
INSERT INTO listening VALUES('2e4396d4-d1c7-11ec-9d64-0242ac120002','The question have object','Guess the structure of the passive voice. Identify similarities and differences between things. Identify positional relationships between objects.','37','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_3.mp3?alt=media&token=8e243793-ec3c-4d2d-89ff-91fdcacb4eb4','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_3.png?alt=media&token=f97a3af5-9b03-4d68-9635-668a836e9a23');
INSERT INTO listening VALUES('2e4397ce-d1c7-11ec-9d64-0242ac120002','The question have natural landspace','Guess vocabulary about nature or interesting things. identify relationships between things. Predetermine frequently question phrases.','37','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_4.mp3?alt=media&token=e0838ede-78a8-4645-8e31-f197acbb1ef0','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_3.png?alt=media&token=f97a3af5-9b03-4d68-9635-668a836e9a23');
INSERT INTO listening VALUES('2e439c6a-d1c7-11ec-9d64-0242ac120002','Who/Where question','Who is a question about who remains, a specific title. Where is a question about a place, a particular place.','40','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_5.mp3?alt=media&token=6cb60f93-03ac-4a0c-a2c7-607572381dfd','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_5.png?alt=media&token=06286a41-2abc-469d-a8b8-55f29003aff7');
INSERT INTO listening VALUES('2e439d5a-d1c7-11ec-9d64-0242ac120002','When/Which question','When is a question about a time in the past or future. Which is a choice question.','42','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_6.mp3?alt=media&token=c1df4f6d-030e-43fc-a5a0-46ed28dbfe07','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_6.png?alt=media&token=0b0e7711-9a38-4c0a-9f83-bed7acbb95af');
INSERT INTO listening VALUES('2e439e4a-d1c7-11ec-9d64-0242ac120002','Why/How/What question','Why is a question about a reason, specifically stating a reason or making a suggestion. How is a question of manner, of quantity, of distance. What is a question about what, what time asks about time,...','43','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_7.mp3?alt=media&token=8aa84590-bded-4c71-9b51-5c265d508468','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_7.png?alt=media&token=ef51bbd1-5e7c-493f-9f74-123c06e3dad1');
INSERT INTO listening VALUES('2e439f3a-d1c7-11ec-9d64-0242ac120002','Yes/No question','Yes/No is a question about have done something or want to verify something.','48','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_8.mp3?alt=media&token=4d1f9b6f-1747-461f-a41a-cc6893a641a1','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_8.png?alt=media&token=e36873cd-92e3-4931-9378-274ef96feb0c');
INSERT INTO listening VALUES('2e43a02a-d1c7-11ec-9d64-0242ac120002','Selection question','Selection question is a question about choice but cannot be answered with Yes/No but must answer with specific answers.','40','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_9.mp3?alt=media&token=69b35721-9ff1-451f-99e2-6c24a7e85fb4','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_9.png?alt=media&token=b5857d6c-556f-4382-b758-64dd1e7af1d3');
INSERT INTO listening VALUES('2e43a106-d1c7-11ec-9d64-0242ac120002','Company conservation','Listen to the main content and need to reason about the problem first. When there are structures like could you? Please pay attention to the content that appears immediately after.','180','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_10.mp3?alt=media&token=9aa2537e-8e43-4ad8-bbe6-a751b01271e8','https://firebasestorage.googleapis.com/v0/b/elsimple-4d688.appspot.com/o/lesson_10.png?alt=media&token=c3f62105-a1a1-4341-a76b-8959c5f9cc7c');

INSERT INTO listeningquestion VALUES('09c7d17e-dc0a-11ec-9d64-0242ac120002','2e439328-d1c7-11ec-9d64-0242ac120002','The woman is ___ the street with a broom.','cleaning');
INSERT INTO listeningquestion VALUES('09c7d3a4-dc0a-11ec-9d64-0242ac120002','2e439328-d1c7-11ec-9d64-0242ac120002','The woman is ___  the girl''s arm.','examining');
INSERT INTO listeningquestion VALUES('09c7d570-dc0a-11ec-9d64-0242ac120002','2e439328-d1c7-11ec-9d64-0242ac120002','He is ___ a phone conservation at the desk.','conducting');
INSERT INTO listeningquestion VALUES('09c7d688-dc0a-11ec-9d64-0242ac120002','2e439328-d1c7-11ec-9d64-0242ac120002','The speaker is ___ into the microphone.','speaking');
INSERT INTO listeningquestion VALUES('09c7d7a0-dc0a-11ec-9d64-0242ac120002','2e439328-d1c7-11ec-9d64-0242ac120002','He is ___ on the paper with a pen.','writing');
INSERT INTO listeningquestion VALUES('09c7d8ae-dc0a-11ec-9d64-0242ac120002','2e439328-d1c7-11ec-9d64-0242ac120002','She is ___ the liquid into the cup.','pouring');
INSERT INTO listeningquestion VALUES('09c7d9b2-dc0a-11ec-9d64-0242ac120002','2e439328-d1c7-11ec-9d64-0242ac120002','The man is ___ at the computer.','working');
INSERT INTO listeningquestion VALUES('09c7dc3c-dc0a-11ec-9d64-0242ac120002','2e439328-d1c7-11ec-9d64-0242ac120002','A woman is ___ something under her arm.','carrying');
INSERT INTO listeningquestion VALUES('09c7dd4a-dc0a-11ec-9d64-0242ac120002','2e439594-d1c7-11ec-9d64-0242ac120002','They are ___ a document.','looking at');
INSERT INTO listeningquestion VALUES('09c7de4e-dc0a-11ec-9d64-0242ac120002','2e439594-d1c7-11ec-9d64-0242ac120002','They are ___ the audience.','speaking to');
INSERT INTO listeningquestion VALUES('09c7df52-dc0a-11ec-9d64-0242ac120002','2e439594-d1c7-11ec-9d64-0242ac120002','The musicians are ___ instruments.','playing different');
INSERT INTO listeningquestion VALUES('09c7e060-dc0a-11ec-9d64-0242ac120002','2e439594-d1c7-11ec-9d64-0242ac120002','They are ___ in a row.','lining up');
INSERT INTO listeningquestion VALUES('09c7e164-dc0a-11ec-9d64-0242ac120002','2e439594-d1c7-11ec-9d64-0242ac120002','They are ___ from each other.','sitting across');
INSERT INTO listeningquestion VALUES('09c7e268-dc0a-11ec-9d64-0242ac120002','2e439594-d1c7-11ec-9d64-0242ac120002','They are ___.','having a meeting');
INSERT INTO listeningquestion VALUES('09c7e588-dc0a-11ec-9d64-0242ac120002','2e439594-d1c7-11ec-9d64-0242ac120002','Children are ___ the water fountain.','drinking from');
INSERT INTO listeningquestion VALUES('09c7e7cc-dc0a-11ec-9d64-0242ac120002','2e439594-d1c7-11ec-9d64-0242ac120002','The travelers are ___ their suitcases.','waiting with');
INSERT INTO listeningquestion VALUES('09c7e8e4-dc0a-11ec-9d64-0242ac120002','2e4396d4-d1c7-11ec-9d64-0242ac120002','The kitchen is ___.','being cleaned');
INSERT INTO listeningquestion VALUES('09c7e9f2-dc0a-11ec-9d64-0242ac120002','2e4396d4-d1c7-11ec-9d64-0242ac120002','The shoes ___ on the shelf.','are displayed');
INSERT INTO listeningquestion VALUES('09c7eaf6-dc0a-11ec-9d64-0242ac120002','2e4396d4-d1c7-11ec-9d64-0242ac120002','___  over both doors.','There are arches');
INSERT INTO listeningquestion VALUES('09c7ec0e-dc0a-11ec-9d64-0242ac120002','2e4396d4-d1c7-11ec-9d64-0242ac120002','The driveway is ___ .','being paved');
INSERT INTO listeningquestion VALUES('09c7ed12-dc0a-11ec-9d64-0242ac120002','2e4396d4-d1c7-11ec-9d64-0242ac120002','A vehicle ___  next to the building.','is parked');
INSERT INTO listeningquestion VALUES('09c7f0e6-dc0a-11ec-9d64-0242ac120002','2e4396d4-d1c7-11ec-9d64-0242ac120002','The boats have ___  at the dock.','been lined up');
INSERT INTO listeningquestion VALUES('09c7f208-dc0a-11ec-9d64-0242ac120002','2e4396d4-d1c7-11ec-9d64-0242ac120002','Several cars ___  at a stop sign.','are stopped');
INSERT INTO listeningquestion VALUES('09c7f30c-dc0a-11ec-9d64-0242ac120002','2e4396d4-d1c7-11ec-9d64-0242ac120002','The desk ___ .','is unoccupied');
INSERT INTO listeningquestion VALUES('09c7f410-dc0a-11ec-9d64-0242ac120002','2e4397ce-d1c7-11ec-9d64-0242ac120002','The path is ___ a forest.','passing through');
INSERT INTO listeningquestion VALUES('09c7f51e-dc0a-11ec-9d64-0242ac120002','2e4397ce-d1c7-11ec-9d64-0242ac120002','Skyscrapers ___ the city.','tower over');
INSERT INTO listeningquestion VALUES('09c7f62c-dc0a-11ec-9d64-0242ac120002','2e4397ce-d1c7-11ec-9d64-0242ac120002','There is a ___ along the sidewalk.','grassy area');
INSERT INTO listeningquestion VALUES('09c7f744-dc0a-11ec-9d64-0242ac120002','2e4397ce-d1c7-11ec-9d64-0242ac120002','The mountain peak is ___ the snow.','covered with');
INSERT INTO listeningquestion VALUES('09c7f85c-dc0a-11ec-9d64-0242ac120002','2e4397ce-d1c7-11ec-9d64-0242ac120002','The lake is ___.','very calm');
INSERT INTO listeningquestion VALUES('09c7fac8-dc0a-11ec-9d64-0242ac120002','2e4397ce-d1c7-11ec-9d64-0242ac120002','There are ___ around the tall buildings.','some trees');
INSERT INTO listeningquestion VALUES('09c7fbfe-dc0a-11ec-9d64-0242ac120002','2e4397ce-d1c7-11ec-9d64-0242ac120002','The boats are ___ in the water.','floating');
INSERT INTO listeningquestion VALUES('09c7fd0c-dc0a-11ec-9d64-0242ac120002','2e4397ce-d1c7-11ec-9d64-0242ac120002','There is a ___ the lake.','birdge over');
INSERT INTO listeningquestion VALUES('09c7fe1a-dc0a-11ec-9d64-0242ac120002','2e439c6a-d1c7-11ec-9d64-0242ac120002','___ this report?','Who made');
INSERT INTO listeningquestion VALUES('09c7ff3c-dc0a-11ec-9d64-0242ac120002','2e439c6a-d1c7-11ec-9d64-0242ac120002','___ did you ___ this camera?','Where / buy');
INSERT INTO listeningquestion VALUES('09c8004a-dc0a-11ec-9d64-0242ac120002','2e439c6a-d1c7-11ec-9d64-0242ac120002','___ the meeting?','Who chaired');
INSERT INTO listeningquestion VALUES('09c80130-dc0a-11ec-9d64-0242ac120002','2e439c6a-d1c7-11ec-9d64-0242ac120002','___ can I take the ___ near here?','Where / bus');
INSERT INTO listeningquestion VALUES('09c80306-dc0a-11ec-9d64-0242ac120002','2e439c6a-d1c7-11ec-9d64-0242ac120002','___ are you planning to ___?','Where / go ');
INSERT INTO listeningquestion VALUES('09c803ec-dc0a-11ec-9d64-0242ac120002','2e439c6a-d1c7-11ec-9d64-0242ac120002','___ me with this proposal?','Who can help');
INSERT INTO listeningquestion VALUES('09c804c8-dc0a-11ec-9d64-0242ac120002','2e439c6a-d1c7-11ec-9d64-0242ac120002','___ did you ___ the news?','Where / hear');
INSERT INTO listeningquestion VALUES('09c805ae-dc0a-11ec-9d64-0242ac120002','2e439c6a-d1c7-11ec-9d64-0242ac120002','___ the sales department?','Who is in charge of');
INSERT INTO listeningquestion VALUES('09c80856-dc0a-11ec-9d64-0242ac120002','2e439d5a-d1c7-11ec-9d64-0242ac120002','___ supposed to start?','When is the snow');
INSERT INTO listeningquestion VALUES('09c80932-dc0a-11ec-9d64-0242ac120002','2e439d5a-d1c7-11ec-9d64-0242ac120002','___ turns off the camcorder?','Which button');
INSERT INTO listeningquestion VALUES('09c80a18-dc0a-11ec-9d64-0242ac120002','2e439d5a-d1c7-11ec-9d64-0242ac120002','___ are you going to ___?','When / finish the project');
INSERT INTO listeningquestion VALUES('09c80af4-dc0a-11ec-9d64-0242ac120002','2e439d5a-d1c7-11ec-9d64-0242ac120002','___ should I ___ for the staff meeting?','When / reserve');
INSERT INTO listeningquestion VALUES('09c80bd0-dc0a-11ec-9d64-0242ac120002','2e439d5a-d1c7-11ec-9d64-0242ac120002','___ today?','When are you leaving');
INSERT INTO listeningquestion VALUES('09c80cac-dc0a-11ec-9d64-0242ac120002','2e439d5a-d1c7-11ec-9d64-0242ac120002','___, the red one or the blue one?','Which do you prefer');
INSERT INTO listeningquestion VALUES('09c80d7e-dc0a-11ec-9d64-0242ac120002','2e439d5a-d1c7-11ec-9d64-0242ac120002','___ you start your ___?','When will / new job');
INSERT INTO listeningquestion VALUES('09c80e5a-dc0a-11ec-9d64-0242ac120002','2e439d5a-d1c7-11ec-9d64-0242ac120002','___ goes to London?','Which train');
INSERT INTO listeningquestion VALUES('09c8104e-dc0a-11ec-9d64-0242ac120002','2e439e4a-d1c7-11ec-9d64-0242ac120002','___ to have for lunch?','Which do you want');
INSERT INTO listeningquestion VALUES('09c8112a-dc0a-11ec-9d64-0242ac120002','2e439e4a-d1c7-11ec-9d64-0242ac120002','___ have you worked here?','How long');
INSERT INTO listeningquestion VALUES('09c811fc-dc0a-11ec-9d64-0242ac120002','2e439e4a-d1c7-11ec-9d64-0242ac120002','___ join us for coffee?','Why don''t you');
INSERT INTO listeningquestion VALUES('09c812d8-dc0a-11ec-9d64-0242ac120002','2e439e4a-d1c7-11ec-9d64-0242ac120002','___ about the damaged shipment?','What should I do');
INSERT INTO listeningquestion VALUES('09c813b4-dc0a-11ec-9d64-0242ac120002','2e439e4a-d1c7-11ec-9d64-0242ac120002','___ learn about the bid?','How did you');
INSERT INTO listeningquestion VALUES('09c815f8-dc0a-11ec-9d64-0242ac120002','2e439e4a-d1c7-11ec-9d64-0242ac120002','___ do you need?','How many copies');
INSERT INTO listeningquestion VALUES('09c816d4-dc0a-11ec-9d64-0242ac120002','2e439e4a-d1c7-11ec-9d64-0242ac120002','___ the new manager?','What do you think of');
INSERT INTO listeningquestion VALUES('09c817b0-dc0a-11ec-9d64-0242ac120002','2e439e4a-d1c7-11ec-9d64-0242ac120002','___ the copier working?','Why isn''t');
INSERT INTO listeningquestion VALUES('09c81882-dc0a-11ec-9d64-0242ac120002','2e439f3a-d1c7-11ec-9d64-0242ac120002','___ to process the application?','Is there a faster way');
INSERT INTO listeningquestion VALUES('09c8195e-dc0a-11ec-9d64-0242ac120002','2e439f3a-d1c7-11ec-9d64-0242ac120002','___ will replace Carol''s work?','Do you know who');
INSERT INTO listeningquestion VALUES('09c81a3a-dc0a-11ec-9d64-0242ac120002','2e439f3a-d1c7-11ec-9d64-0242ac120002','___ Tim recently?','Have you heard about');
INSERT INTO listeningquestion VALUES('09c81b20-dc0a-11ec-9d64-0242ac120002','2e439f3a-d1c7-11ec-9d64-0242ac120002','___ while I was out?','Were there any messages');
INSERT INTO listeningquestion VALUES('09c81bfc-dc0a-11ec-9d64-0242ac120002','2e439f3a-d1c7-11ec-9d64-0242ac120002','___ to work today?','Did you take the bus');
INSERT INTO listeningquestion VALUES('09c81e9a-dc0a-11ec-9d64-0242ac120002','2e439f3a-d1c7-11ec-9d64-0242ac120002','___ her name, K-A-T-Y?','Does she spell');
INSERT INTO listeningquestion VALUES('09c81f76-dc0a-11ec-9d64-0242ac120002','2e439f3a-d1c7-11ec-9d64-0242ac120002','___ the invitations yesterday?','Did you send out');
INSERT INTO listeningquestion VALUES('09c82052-dc0a-11ec-9d64-0242ac120002','2e439f3a-d1c7-11ec-9d64-0242ac120002','___ to the headquarters?','Have you ever been');
INSERT INTO listeningquestion VALUES('09c82124-dc0a-11ec-9d64-0242ac120002','2e43a02a-d1c7-11ec-9d64-0242ac120002','Would you like ___ or ___?','a window seat / an aisle seat');
INSERT INTO listeningquestion VALUES('09c821f6-dc0a-11ec-9d64-0242ac120002','2e43a02a-d1c7-11ec-9d64-0242ac120002','Do you want to ___ yourself or ___?','chair the meeting / should I do that');
INSERT INTO listeningquestion VALUES('09c822d2-dc0a-11ec-9d64-0242ac120002','2e43a02a-d1c7-11ec-9d64-0242ac120002','Would it better to advertise ___ or ___?','in print / on the radion');
INSERT INTO listeningquestion VALUES('09c823ae-dc0a-11ec-9d64-0242ac120002','2e43a02a-d1c7-11ec-9d64-0242ac120002','Would you like to ___ or ___?','go to a concert / go shopping');
INSERT INTO listeningquestion VALUES('09c8248a-dc0a-11ec-9d64-0242ac120002','2e43a02a-d1c7-11ec-9d64-0242ac120002','Have you already ___ or ___?','made copies / should i do it');
INSERT INTO listeningquestion VALUES('09c826ce-dc0a-11ec-9d64-0242ac120002','2e43a02a-d1c7-11ec-9d64-0242ac120002','Do you want to ___ or ___?','take the train / express bus');
INSERT INTO listeningquestion VALUES('09c827aa-dc0a-11ec-9d64-0242ac120002','2e43a02a-d1c7-11ec-9d64-0242ac120002','Are you ___ or ___ home?','taking a bus / can I give you a ride');
INSERT INTO listeningquestion VALUES('09c8287c-dc0a-11ec-9d64-0242ac120002','2e43a02a-d1c7-11ec-9d64-0242ac120002','Would you like an appointment ___ or ___?','in the morning / in the afternoon');
INSERT INTO listeningquestion VALUES('09c8294e-dc0a-11ec-9d64-0242ac120002','2e43a106-d1c7-11ec-9d64-0242ac120002','What does the woman want?','A supervisor''s phone number');
INSERT INTO listeningquestion VALUES('09c82a20-dc0a-11ec-9d64-0242ac120002','2e43a106-d1c7-11ec-9d64-0242ac120002','Where is the department head?','At home');
INSERT INTO listeningquestion VALUES('09c82afc-dc0a-11ec-9d64-0242ac120002','2e43a106-d1c7-11ec-9d64-0242ac120002','What does the man suggest the woman do?','Speak with Emiko');
INSERT INTO listeningquestion VALUES('09c82be2-dc0a-11ec-9d64-0242ac120002','2e43a106-d1c7-11ec-9d64-0242ac120002','What are the speakers discussing?','A printing error');
INSERT INTO listeningquestion VALUES('09c82db8-dc0a-11ec-9d64-0242ac120002','2e43a106-d1c7-11ec-9d64-0242ac120002','What does the woman ask the man to do?','Proofread the seminar schedule');
INSERT INTO listeningquestion VALUES('09c82e94-dc0a-11ec-9d64-0242ac120002','2e43a106-d1c7-11ec-9d64-0242ac120002','What does the woman offer to do?','Extend a deadline');
INSERT INTO listeningquestion VALUES('09c82f66-dc0a-11ec-9d64-0242ac120002','2e43a106-d1c7-11ec-9d64-0242ac120002','Who is the woman most likely talking to?','Her co-worker');
INSERT INTO listeningquestion VALUES('09c83038-dc0a-11ec-9d64-0242ac120002','2e43a106-d1c7-11ec-9d64-0242ac120002','What does the man say about the software installation?','He wants it done on his computer');