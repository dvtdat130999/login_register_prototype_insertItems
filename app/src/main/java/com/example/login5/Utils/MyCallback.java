package com.example.login5.Utils;

import java.util.HashMap;
import java.util.List;

public interface MyCallback {
    void onComplete(List<List<HashMap<String, String>>> routes, List<Integer> distances);
}
