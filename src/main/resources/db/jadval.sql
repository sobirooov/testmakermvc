
create table testmaker.questions(id serial primary key, text_value text not null);

create table testmaker.answers(id serial primary key, question_id integer, text_value text not null , is_correct boolean not null default false,
                               CONSTRAINT fk_question
                                   FOREIGN KEY (question_id) REFERENCES questions(id)
                                       ON DELETE CASCADE
);