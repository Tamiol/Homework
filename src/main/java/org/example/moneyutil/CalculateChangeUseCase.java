package org.example.moneyutil;

import lombok.Value;
import org.example.model.ChangeDTO;

import java.util.List;

public interface CalculateChangeUseCase {

    List<ChangeDTO> calculate(int value);

}
