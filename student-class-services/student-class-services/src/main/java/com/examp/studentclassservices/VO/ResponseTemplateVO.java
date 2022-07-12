package com.examp.studentclassservices.VO;

import com.examp.studentclassservices.entity.StudentClass;
import com.examp.studentclassservices.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    //it is wrapper object for two related objects

    private StudentClass studentClass;
    private Subject subject;
}
