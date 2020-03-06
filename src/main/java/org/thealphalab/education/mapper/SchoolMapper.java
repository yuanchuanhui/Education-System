package org.thealphalab.education.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.School;

@Repository
public interface SchoolMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school
     *
     * @mbggenerated Mon Mar 02 16:31:24 MYT 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school
     *
     * @mbggenerated Mon Mar 02 16:31:24 MYT 2020
     */
    int insert(School record);

    int insertAll(List<School> schools);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school
     *
     * @mbggenerated Mon Mar 02 16:31:24 MYT 2020
     */
    School selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school
     *
     * @mbggenerated Mon Mar 02 16:31:24 MYT 2020
     */
    List<School> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school
     *
     * @mbggenerated Mon Mar 02 16:31:24 MYT 2020
     */
    int updateByPrimaryKey(School record);
}