package com.example.Lalan.Repos;

import com.example.Lalan.DTO.LineRegistrationDTO;
import com.example.Lalan.Entity.AdminEntity;
import com.example.Lalan.Entity.LineRegistrationEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import org.hibernate.mapping.Value;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AdminRepo extends JpaRepository<AdminEntity, String> {

        // select job id and retrieve batch id
        public static final String sqlquerypart2 = "call sp_GetBatchID(?1)";

        @Query(value = sqlquerypart2, nativeQuery = true)
        public List<Object[]> getallbactchidssbyprocedure(String job_id_ad);

        public static final String sqlquerypart3 = "call sp_GetLineDetailsByDate(?1)";

        @Query(value = sqlquerypart3, nativeQuery = true)
        public List<Map<ActiveObjectMap.Key, Value>> getLineByDate(Date predicted_date);

        // get Get Customer Details By Date And LineId
        public static final String sqlquerypart4 = "call sp_GetDetailsByDateAndLineId(?1 , ?2)";

        @Query(value = sqlquerypart4, nativeQuery = true)
        public List<Map<ActiveObjectMap.Key, Value>> GetDetailsByDateAndLineId(Date predicted_date, String LineId);

        // get Get Customer Details By Date And LineId
        public static final String sqlquerypart5 = "call sp_GetDetailsByDateAndLineIdAndPOrder(?1 , ?2 , ?3)";

        @Query(value = sqlquerypart5, nativeQuery = true)
        public List<Map<ActiveObjectMap.Key, Value>> GetDetailsByDateAndLineIdAndPOrder(Date predicted_date,
                        String LineId,
                        int pOrder);

        // get Get Perameters By Date And LineId and pOrder and Machine Id
        public static final String sqlquerypart6 = "call sp_GetDetailsByDateAndLineIdAndPOrderAndMachineId(?1 , ?2 , ?3, ?4)";

        @Query(value = sqlquerypart6, nativeQuery = true)
        public List<Map<ActiveObjectMap.Key, Value>> GetDetailsByDateAndLineIdAndPOrderAndMachineId(Date predicted_date,
                        String LineId, int pOrder, String MachineId);

        // get values to the table
        public static final String sqlquerypart7 = "call sp_GetValueByDevice(?1 , ?2 , ?3, ?4 , ?5 , ?6 , ?7 , ?8)";

        @Query(value = sqlquerypart7, nativeQuery = true)
        public List<Map<ActiveObjectMap.Key, Value>> GetValueByDevice(String Jobid, String batchid, String LineId,
                        int pOrder, String MachineId, String DeviceId, String PerId, Date Date11);

}
