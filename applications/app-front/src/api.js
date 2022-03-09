import axios from "axios";

const serverUrl = 'http://localhost:8080';
const api = {
  get: async (url, data) => {
    try {
      const response = await axios.get(`${serverUrl}/${url}`, data);

      if (response.status === 200) {
        return response.data;
      }

      return response;
    } catch (err) {
      return Promise.reject(err);
    }
  },

  post: async (url, data) => {
    try {
      const response = await axios.post(`${serverUrl}/${url}`, data);

      return response;
    } catch (err) {
      return Promise.reject(err);
    }
  },

  patch: async (url, data) => {
    try {
      const response = await axios.patch(`${serverUrl}/${url}`, data);

      return response;
    } catch (err) {
      return Promise.reject(err);
    }
  },

  delete: async (url, data) => {
    try {
      const response = await axios.delete(`${serverUrl}/${url}`, data);

      return response;
    } catch (err) {
      return Promise.reject(err);
    }
  }
};

export default api;