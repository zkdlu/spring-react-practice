const serverUrl = "http://localhost:8080";
const api = {
    get: async (url) => {
        const response = await fetch(`${serverUrl}/${url}`, {
            mode: "no-cors"
        });
        return response.json();
    },
    post: async (url, body) => {
        const response = await fetch(`${serverUrl}/${url}`, {
            method: "POST",
            mode: "no-cors",
            headers: {
                "Content-Type": "application/json",  
            },
            body: JSON.stringify(body),
        });

        return response;
    }
};

export default api;